package org.training.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.hash.Crypt;
import org.training.calculator.operations.math.MathOperations;
import org.training.calculator.service.Calculator;
import org.training.calculator.service.HashCalculator;
import org.training.calculator.service.MathCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Enter an expression: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Calculator calculator = new MathCalculator(new MathOperations());
        LOG.info(calculator.calculate(input));


        Calculator hashCalculator = new HashCalculator(new Crypt());
        LOG.info(hashCalculator.calculate("Doctors"));


    }
}

