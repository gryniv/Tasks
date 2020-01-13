package org.training.calculator.operations.hash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Decrypt {


    private static final Logger LOG = LogManager.getLogger(Decrypt.class);
    private static final int[][] RANGES;
    private static final String[] CHARACTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int THRESHOLD;
    private static final int AVAILABLE_PROCESSORS;
    private static final Hash CALCULATOR = new Crypt();
    private static String TARGET;
    private static int rangeCounter = 0;
    private static AtomicBoolean isCompleted = new AtomicBoolean();
    private static ExecutorService service;

    static {
        AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
        RANGES = new int[AVAILABLE_PROCESSORS][2];
        THRESHOLD = CHARACTERS.length / AVAILABLE_PROCESSORS;
    }

    private static String per(final String chars, int position) throws IOException {
        if (position == 0) {
            if (isCompleted.get()) {
                throw new RuntimeException();
            }
            final String hash = CALCULATOR.md5(chars);
            if (TARGET.equals(hash)) {
                isCompleted.set(true);
                service.shutdownNow();
                LOG.info("Hash found, key: " + chars);
            }
        } else {
            for (final String character : CHARACTERS) {
                per(chars + character, position - 1);
            }
        }

        return chars;
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

    public void md5(String o) {
        TARGET = o;
        fillRanges(0, CHARACTERS.length - 1);

        service = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS);
        for (final int[] range : RANGES) {
            final int start = range[0];
            final int end = range[1];
            service.submit(() -> {
                for (int i = 0; i < CHARACTERS.length; i++) {
                    for (int k = start; k < end; k++) {
                        try {
                            per(CHARACTERS[k], i);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

}