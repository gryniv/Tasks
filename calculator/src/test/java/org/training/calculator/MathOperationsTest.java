package org.training.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MathOperationsTest {
    String littleEquation;
    String bigEquation;
    MathOperations mathOperations = new MathOperations();

    @Before
    public void setUp(){
    littleEquation = "2+2*2";
    bigEquation = "2+2+2+2*2";
    }

    @Test
    public void calculate() {
        Assert.assertEquals(littleEquation + " Must be equal 6", "6", mathOperations.calculate(littleEquation));
        Assert.assertEquals(bigEquation + " Must be equal 10", "10", mathOperations.calculate(bigEquation));
    }
}