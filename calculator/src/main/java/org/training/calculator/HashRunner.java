package org.training.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.hash.HashOperations;
import org.training.calculator.operations.hash.MD5HashOperations;
import org.training.calculator.service.Calculator;
import org.training.calculator.service.impl.MD5HashCalculator;

import java.io.IOException;

public class HashRunner {
    private static final Logger LOG = LogManager.getLogger(HashRunner.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Enter an expression: "); // 4fd0101ea3d0f5abbe296ef97f47afec
//        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String input = "decode 4fd0101ea3d0f5abbe296ef97f47afec";

        HashOperations operations = new MD5HashOperations();
        Calculator hashCalculator = new MD5HashCalculator(operations);

        final String result = hashCalculator.calculate(input);
        LOG.info("Result: {}", result);
    }
}

