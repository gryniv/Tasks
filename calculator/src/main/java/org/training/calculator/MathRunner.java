package org.training.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.math.MathOperations;
import org.training.calculator.service.Calculator;
import org.training.calculator.service.impl.MathCalculator;

public class MathRunner {
    private static final Logger LOG = LogManager.getLogger(MathRunner.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Enter an expression: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Calculator calculator = new MathCalculator(new MathOperations());
        final var result = calculator.calculate(input);
        LOG.info("Result: {}", result);
    }
}