package org.training.circularbuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.circularbuffer.service.ArrayCircularBuffer;

import java.util.Arrays;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        LOG.info("Enter an expression: ");
        ArrayCircularBuffer<String> buffer1 = new ArrayCircularBuffer<>(10);
        ArrayCircularBuffer<String> buffer2 = new ArrayCircularBuffer<>(10, String.class); // this work correct
        buffer1.put("0");
        buffer2.put("0");
        buffer1.put("1");
        buffer2.put("1");
        String[] asArray2 = buffer2.toArray();
        buffer1.put("1");
        System.out.println(Arrays.toString(asArray2));
    }
}

