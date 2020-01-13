package org.training.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.hash.Decrypt;

import java.io.IOException;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {
        String input = "4fd0101ea3d0f5abbe296ef97f47afec";

        LOG.info("Enter an expression: " + input);
        Decrypt hashCalculator = new Decrypt();

        hashCalculator.md5(input);
    }
}

