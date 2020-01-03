package org.training.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.calculator.operations.hash.Decrypt;
import org.training.calculator.service.HashCalculator;

import java.io.IOException;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {
        String input = "4fd0101ea3d0f5abbe296ef97f47afec";

        LOG.info("Enter an expression: " + input);
//        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
//        Calculator calculator = new MathCalculator(new MathOperations());
//        LOG.info(calculator.calculate(input));

        HashCalculator hashCalculator = new HashCalculator(new Decrypt(2));
        LOG.info("your secret string is: " + hashCalculator.calculate().md5(input));


    }
}

