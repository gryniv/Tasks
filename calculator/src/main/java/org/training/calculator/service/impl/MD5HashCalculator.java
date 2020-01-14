package org.training.calculator.service.impl;

import org.training.calculator.operations.hash.HashOperations;
import org.training.calculator.service.HashCalculator;

public class MD5HashCalculator implements HashCalculator {

    private HashOperations operations;

    public MD5HashCalculator(final HashOperations operations) {
        this.operations = operations;
    }

    @Override
    public String encode(final String input) {
        return operations.encode(input);
    }

    @Override
    public String decode(final String input) {
        return operations.decode(input);
    }
}
