package org.training.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MathCalculatorTest {
    private static final String MULTIPLE_OPERATION = "3*2";
    private static final String EXPECTED_MULTIPLE_RESULT = "6";
    private static final String MULTIPLE_FACTIONAL_OPERATION = "3*2.5";
    private static final String EXPECTED_MULTIPLE_FACTIONAL_RESULT = "7.5";
    private static final String DIVIDE_OPERATION = "3/3";
    private static final String EXPECTED_DIVIDE_RESULT = "1";
    private static final String DIVIDE_FACTIONAL_OPERATION = "3/2";
    private static final String EXPECTED_DIVIDE_FACTIONAL_RESULT = "1.5";
    private static final String PLUS_OPERATION = "2+2";
    private static final String EXPECTED_PLUS_RESULT = "4";
    private static final String PLUS_FACTIONAL_OPERATION = "2+2.5";
    private static final String EXPECTED_PLUS_FACTIONAL_RESULT = "4.5";
    private static final String MINUS_OPERATION = "4-2";
    private static final String EXPECTED_MINUS_RESULT = "2";
    private static final String MINUS_FACTIONAL_OPERATION = "4-2.5";
    private static final String EXPECTED_MINUS_FACTIONAL_RESULT = "1.5";
    private static final String ALL_OPERATIONS = "2+2*2-2/2";
    private static final String EXPECTED_ALL_OPERATIONS_RESULT = "5";
    private static final String ALL_FACTIONAL_OPERATIONS = "2+2*2-2/4";
    private static final String EXPECTED_ALL_FACTIONAL_OPERATIONS_RESULT = "5.5";
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new MathCalculator(new MathOperations());
    }

    @Test
    public void shouldMultiple() throws IOException {
        final String result = calculator.calculate(MULTIPLE_OPERATION);
        assertEquals(EXPECTED_MULTIPLE_RESULT, result);
    }

    @Test
    public void shouldMultipleFactional() throws IOException {
        final String result = calculator.calculate(MULTIPLE_FACTIONAL_OPERATION);
        assertEquals(EXPECTED_MULTIPLE_FACTIONAL_RESULT, result);
    }

    @Test
    public void shouldDivide() throws IOException {
        final String result = calculator.calculate(DIVIDE_OPERATION);
        assertEquals(EXPECTED_DIVIDE_RESULT, result);
    }

    @Test
    public void shouldDivideFactional() throws IOException {
        final String result = calculator.calculate(DIVIDE_FACTIONAL_OPERATION);
        assertEquals(EXPECTED_DIVIDE_FACTIONAL_RESULT, result);
    }

    @Test
    public void shouldPlus() throws IOException {
        final String result = calculator.calculate(PLUS_OPERATION);
        assertEquals(EXPECTED_PLUS_RESULT, result);
    }

    @Test
    public void shouldPlusFactional() throws IOException {
        final String result = calculator.calculate(PLUS_FACTIONAL_OPERATION);
        assertEquals(EXPECTED_PLUS_FACTIONAL_RESULT, result);
    }

    @Test
    public void shouldMinus() throws IOException {
        final String result = calculator.calculate(MINUS_OPERATION);
        assertEquals(EXPECTED_MINUS_RESULT, result);
    }

    @Test
    public void shouldMinusFactional() throws IOException {
        final String result = calculator.calculate(MINUS_FACTIONAL_OPERATION);
        assertEquals(EXPECTED_MINUS_FACTIONAL_RESULT, result);
    }

    @Test
    public void shouldCalculateWithAllOperations() throws IOException {
        final String result = calculator.calculate(ALL_OPERATIONS);
        assertEquals(EXPECTED_ALL_OPERATIONS_RESULT, result);
    }

    @Test
    public void shouldCalculateWithAllFactionalOperations() throws IOException {
        final String result = calculator.calculate(ALL_FACTIONAL_OPERATIONS);
        assertEquals(EXPECTED_ALL_FACTIONAL_OPERATIONS_RESULT, result);
    }
}