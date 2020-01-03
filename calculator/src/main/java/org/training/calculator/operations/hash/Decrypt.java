package org.training.calculator.operations.hash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.Runner;
import org.training.calculator.service.HashCalculator;

import java.io.IOException;

public class Decrypt implements Hash {

    private final int searchLength;
    private final char[] ABC;
    private final HashCalculator hashCalculator;
    private static final Logger LOG = LogManager.getLogger(Runner.class);


    public Decrypt(int searchLength) {
        this.searchLength = searchLength;
        this.ABC = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.hashCalculator = new HashCalculator(new Crypt());

    }

    @Override
    public String md5(String o) throws IOException {
        long arrayLength = ABC.length;
        long[] sizeOfVariants = optionNumbers(arrayLength);
        for (int i = 0; i <= searchLength; i++) {
            for (int j = 0; j < sizeOfVariants[i]; j++) {
                char[] array = new char[i];
                for (int k = 0; k < i; k++) {
                    array[k] = ABC[(int) ((j / sizeOfVariants[k]) % arrayLength)];
                }
                String stringArray = new String(array);
                if (o.equals(hashCalculator.calculate().md5(stringArray))) {
                    return stringArray;
                }
            }
        }
        return "ERROR, LENGTH OF YOUR SECRET STRING - BIGGER THEN " + searchLength;
    }

    private long[] optionNumbers(long arrayLength) {
        long[] sizeOfVariants = new long[searchLength + 1];
        sizeOfVariants[0] = 1;
        for (int i = 1; i <= searchLength; i++) {
            sizeOfVariants[i] = sizeOfVariants[i - 1] * arrayLength;
        }
        return sizeOfVariants;
    }
}
