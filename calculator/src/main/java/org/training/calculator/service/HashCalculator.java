package org.training.calculator.service;

import org.training.calculator.operations.hash.Crypt;
import org.training.calculator.operations.hash.Decrypt;
import org.training.calculator.operations.hash.Hash;

public final class HashCalculator implements Calculator {

    private Hash calculate;
    private String hashType;

    public HashCalculator(Crypt crypt) {
        this.calculate = crypt;
    }

    public HashCalculator(Decrypt decrypt) {
        this.calculate = decrypt;
    }

    public String calculate(String input) {

        return calculate.md5(input);

    }
}
