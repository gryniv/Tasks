package org.training.calculator.service;

import org.training.calculator.operations.hash.Crypt;
import org.training.calculator.operations.hash.Decrypt;
import org.training.calculator.operations.hash.Hash;

import java.io.IOException;

public final class HashCalculator {

    private Hash calculator;

    public HashCalculator(Crypt crypt) {
        this.calculator = crypt;
    }

    public HashCalculator(Decrypt decrypt) {
        this.calculator = decrypt;
    }


    public Hash calculate() throws IOException {
        return calculator;
    }
}
