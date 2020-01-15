package org.training.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.hash.HashOperations;
import org.training.calculator.operations.hash.MD5HashOperations;
import org.training.calculator.service.HashCalculator;
import org.training.calculator.service.impl.MD5HashCalculator;

public class HashRunner {
    private static final Logger LOG = LogManager.getLogger(HashRunner.class);

    public static void main(String[] args) {
        String input = "4fd0101ea3d0f5abbe296ef97f47afec";

        LOG.info("Enter an expression: {}", input);
        HashOperations operations = new MD5HashOperations();
        HashCalculator hashCalculator = new MD5HashCalculator(operations);

        final String decode = hashCalculator.decode(input);
        LOG.info("Completed: {}", decode);
    }
}

