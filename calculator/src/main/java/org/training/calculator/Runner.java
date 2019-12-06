package org.training.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Runner {
    private static final Logger LOG = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) throws IOException {
        LOG.info("Enter an expression: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Calculator calculator = new MathCalculator(new MathOperations());
        LOG.info(calculator.calculate(input));
    }
}

