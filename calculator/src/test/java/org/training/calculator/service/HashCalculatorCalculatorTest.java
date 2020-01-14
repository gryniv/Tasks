package org.training.calculator.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.calculator.operations.hash.MD5HashOperations;
import org.training.calculator.service.impl.MD5HashCalculator;

public class HashCalculatorCalculatorTest {
    private HashCalculator hashCalculator;

    @Before
    public void setUp() {
        hashCalculator = new MD5HashCalculator(new MD5HashOperations());
    }

    @Test
    public void shouldCalculateStringToHash() {
        final String expectedString = "f77ccbdb203c19d3d52b12a85f33faf5";
        Assert.assertEquals(expectedString, hashCalculator.encode("Doctors"));
    }

    @Test
    public void shouldDecodeToString() {
        final String expectedHash = "900150983cd24fb0d6963f7d28e17f72";
        Assert.assertEquals("abc", hashCalculator.decode(expectedHash));
    }
}