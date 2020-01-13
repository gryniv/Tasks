package org.training.calculator.service;

import org.training.calculator.operations.hash.Crypt;
import org.training.calculator.operations.hash.Hash;

import java.io.IOException;

public final class HashCalculator extends Thread {

    private Hash calculator;

    public HashCalculator(Crypt crypt) {
        this.calculator = crypt;
    }

    public Hash calculate() throws IOException {
        return calculator;
    }
}
