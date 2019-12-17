package org.training.circularbuffer;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.circularbuffer.service.ArrayCircularBuffer;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        LOG.info("Enter an expression: ");
        ArrayCircularBuffer<String> buffer2 = new ArrayCircularBuffer<>(10); // this work correct
        buffer2.put("1");
        buffer2.put("2");
        String[] asArray2 = buffer2.toArray();
        LOG.debug(Arrays.toString(asArray2));
    }
}

