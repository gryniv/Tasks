package org.training.calculator.operations.hash;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
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
import org.training.calculator.exception.TaskCompletedException;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class MD5HashOperations implements HashOperations {
    private static final Logger LOG = LogManager.getLogger(MD5HashOperations.class);

    private static final String[] CHARACTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String PATTERN = "###.##";
    private static final DecimalFormat FORMAT = new DecimalFormat(PATTERN);
    private final AtomicBoolean isCompleted = new AtomicBoolean();
    private final int[][] ranges;
    private final int threshold;
    private final ExecutorService executorService;
    private int rangeCounter = 0;
    private long startTime;
    private String target;

    public MD5HashOperations() {
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final int threads;
        if (availableProcessors * 2 <= CHARACTERS.length) {
            threads = availableProcessors * 2;
        } else {
            threads = availableProcessors;
        }
        ranges = new int[threads][2];
        threshold = CHARACTERS.length / threads;
        executorService = Executors.newFixedThreadPool(threads);
    }

    @Override
    @SuppressWarnings("UnstableApiUsage deprecation")
    public String encode(final String toHash) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(toHash, StandardCharsets.UTF_8);
        return hasher.hash().toString();
    }

    @Override
    public String decode(final String inputHash) {
        startTime = System.currentTimeMillis();
        target = inputHash;
        fillRanges(0, CHARACTERS.length - 1);

        List<Callable<String>> futureList = new ArrayList<>();
        for (final int[] range : ranges) {
            final int start = range[0];
            final int end = range[1];
            final Callable<String> future = () -> {
                for (int i = 0; i < CHARACTERS.length; i++) {
                    for (int k = start; k < end; k++) {
                        try {
                            permutation(CHARACTERS[k], i);
                        } catch (final InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return e.getMessage();
                        }
                    }
                }
                return EMPTY;
            };
            futureList.add(future);
        }

        try {
            final String decodedValue = executorService.invokeAny(futureList);
            executorService.shutdownNow();
            return decodedValue;
        } catch (final InterruptedException | ExecutionException e) {
            LOG.debug(e.getMessage());
            Thread.currentThread().interrupt();
            return EMPTY;
        }
    }

    private void permutation(final String chars, final int position) throws InterruptedException {
        if (position == 0) {
            if (isCompleted.get()) {
                throw new TaskCompletedException();
            }
            final String hash = encode(chars);
            if (target.equals(hash)) {
                final String total = FORMAT.format((double) (System.currentTimeMillis() - startTime) / 1_000);
                LOG.info("Hash found for {} sec", total);
                isCompleted.set(true);
                throw new InterruptedException(chars);
            }
        } else {
            for (final String character : CHARACTERS) {
                permutation(chars + character, position - 1);
            }
        }
    }

    private void fillRanges(int start, int end) {
        if (end - start <= threshold + 1) {
            LOG.info("[start={}, end={}]", start, end);
            ranges[rangeCounter][0] = start;
            ranges[rangeCounter][1] = end;
            rangeCounter++;
        } else {
            final int middle = start + ((end - start) / 2);
            fillRanges(start, middle);
            fillRanges(middle, end);
        }
    }
}