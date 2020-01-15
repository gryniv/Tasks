package org.training.calculator.operations.math;

public class MathOperations implements Operations {

    @Override
    public double multiple(double numOne, double numTwo) {
        return numOne * numTwo;
    }

    @Override
    public double divide(double numOne, double numTwo) {
        return numOne / numTwo;
    }

    @Override
    public double plus(double numOne, double numTwo) {
        return numOne + numTwo;
    }

    @Override
    public double minus(double numOne, double numTwo) {
        return numOne - numTwo;
    }
}