package org.training.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import static org.training.calculator.MathOperations.calculate;

public class Ui {
    private static final Logger LOG = Logger.getLogger(Ui.class.getName());

    public void init() throws IOException {
        LOG.info("Enter an expression: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        LOG.info(String.valueOf(calculate(input)));
    }
}
