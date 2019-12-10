package org.training.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MathCalculatorTest {
    private static final String littleEquation = "2+2*2";
    private static final String bigEquation = "2+2+2+2*2";
    Calculator calculator = new MathCalculator(new MathOperations());


    @Test
    public void Should() throws IOException {
        Assert.assertEquals(littleEquation + " Must be equal 6", "6", calculator.calculate(littleEquation));
        Assert.assertEquals(bigEquation + " Must be equal 10", "10", calculator.calculate(bigEquation));
    }
}