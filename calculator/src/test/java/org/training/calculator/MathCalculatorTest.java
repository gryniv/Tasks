package org.training.calculator;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathCalculatorTest {
    public static final String EXPECTED_DIVIDE_RESULT = "1.5";
    String littleEquation;
    String bigEquation;
    private Calculator calculator;
    private static final String DIVIDE_OPERATION = "3/2";

    @Before
    public void setUp(){
        calculator = new MathCalculator(new MathOperations());
    littleEquation = "2+2*2";
    bigEquation = "2+2+2+2*2";
    }

    @Test
    public void calculate() throws IOException {
        assertEquals(littleEquation + " Must be equal 6", "6", calculator.calculate(littleEquation));
        assertEquals(bigEquation + " Must be equal 10", "10", calculator.calculate(bigEquation));
    }

    @Test
    public void shouldDivide() throws IOException {
        final String result = calculator.calculate(DIVIDE_OPERATION);

        assertEquals(EXPECTED_DIVIDE_RESULT, result);
    }
}