package org.training.calculator.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.calculator.operations.hash.MD5HashOperations;
import org.training.calculator.service.impl.MD5HashCalculator;

public class HashCalculatorCalculatorTest {
    private Calculator hashCalculator;

    @Before
    public void setUp() {
        hashCalculator = new MD5HashCalculator(new MD5HashOperations());
    }

    @Test
    public void shouldCalculateStringToHash() throws IOException {
        final var input = "encode Doctors";
        final var expectedString = "f77ccbdb203c19d3d52b12a85f33faf5";
        Assert.assertEquals(expectedString, hashCalculator.calculate(input));
    }

    @Test
    public void shouldDecodeToString() throws IOException {
        final var input = "decode 900150983cd24fb0d6963f7d28e17f72";
        final var expectedString = "abc";
        Assert.assertEquals(expectedString, hashCalculator.calculate(input));
    }
}