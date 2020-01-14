package org.training.calculator.operations.hash;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MD5HashOperations implements HashOperations {
    private static final Logger LOG = LogManager.getLogger(MD5HashOperations.class);

    private static final int[][] RANGES;
    private static final String[] CHARACTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int THRESHOLD;
    private static final int AVAILABLE_PROCESSORS;
    private static final String EMPTY_RESULT = "";
    private static int rangeCounter = 0;
    private static final AtomicBoolean IS_COMPLETED = new AtomicBoolean();
    private static final ExecutorService SERVICE;
    private String target;

    static {
        AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
        RANGES = new int[AVAILABLE_PROCESSORS][2];
        THRESHOLD = CHARACTERS.length / AVAILABLE_PROCESSORS;
        SERVICE = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS);
    }

    public String encode(String toHash) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(toHash, StandardCharsets.UTF_8);
        return hasher.hash().toString();
    }

    public String decode(String inputHash) {
        target = inputHash;
        fillRanges(0, CHARACTERS.length - 1);

        List<Callable<String>> futureList = new ArrayList<>();
        for (final int[] range : RANGES) {
            final int start = range[0];
            final int end = range[1];
            Callable<String> f = () -> {
                for (int i = 0; i < CHARACTERS.length; i++) {
                    for (int k = start; k < end; k++) {
                        try {
                            permutation(CHARACTERS[k], i);
                        } catch (InterruptedException e) {
                            return e.getMessage();
                        }
                    }
                }
                return EMPTY_RESULT;
            };
            futureList.add(f);
        }

        try {
            final String decodedValue = SERVICE.invokeAny(futureList);
            SERVICE.shutdownNow();
            return decodedValue;
        } catch (InterruptedException | ExecutionException e) {
            LOG.debug(e.getMessage());
            return EMPTY_RESULT;
        }
    }

    private void permutation(final String chars, int position) throws Exception {
        if (position == 0) {
            if (IS_COMPLETED.get()) {
                throw new RuntimeException();
            }
            final String hash = encode(chars);
            if (target.equals(hash)) {
                IS_COMPLETED.set(true);
                SERVICE.shutdownNow();
                LOG.info("Hash found, key: " + chars);
                throw new InterruptedException(chars);
            }
        } else {
            for (final String character : CHARACTERS) {
                permutation(chars + character, position - 1);
            }
        }
    }

    private static void fillRanges(int start, int end) {
        if (end - start <= THRESHOLD + 1) {
            LOG.info("[start=" + start + ", end=" + end + "]");
            RANGES[rangeCounter][0] = start;
            RANGES[rangeCounter][1] = end;
            rangeCounter++;
        } else {
            final int middle = start + ((end - start) / 2);
            fillRanges(start, middle);
            fillRanges(middle, end);
        }
    }
}