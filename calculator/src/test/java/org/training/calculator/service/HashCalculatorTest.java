package org.training.calculator.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.calculator.operations.hash.Crypt;

import java.io.IOException;

public class HashCalculatorTest {
    private Calculator hashCalculator;
    private String mustReturnHashString = "f77ccbdb203c19d3d52b12a85f33faf5";

    @Before
    public void setUp() {
        hashCalculator = new HashCalculator(new Crypt());
    }

    @Test
    public void shouldCalculateStringToHash() throws IOException {
        Assert.assertEquals(hashCalculator.calculate("Doctors"), mustReturnHashString);
    }
}