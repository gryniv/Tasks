package org.training.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MathCalculatorTest {
    String littleEquation;
    String bigEquation;
    Calculator calculator = new MathCalculator(new MathOperations());

    @Before
    public void setUp(){
    littleEquation = "2+2*2";
    bigEquation = "2+2+2+2*2";
    }

    @Test
    public void calculate() throws IOException {
        Assert.assertEquals(littleEquation + " Must be equal 6", "6", calculator.calculate(littleEquation));
        Assert.assertEquals(bigEquation + " Must be equal 10", "10", calculator.calculate(bigEquation));
    }
}