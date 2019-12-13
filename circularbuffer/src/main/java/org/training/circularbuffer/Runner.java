package org.training.circularbuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.circularbuffer.service.Buffer;
import org.training.circularbuffer.service.CircularBuffer;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        LOG.info("Enter an expression: ");
        Buffer<Integer> buffer = new CircularBuffer<>(5);
    }
}

