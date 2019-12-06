package org.training.calculator;

public class MathOperations implements Operations{

    @Override
    public int Multiple(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public int Divide(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }

    @Override
    public int Plus(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public int Minus(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }
}