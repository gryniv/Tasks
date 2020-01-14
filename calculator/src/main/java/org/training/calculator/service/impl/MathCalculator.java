package org.training.calculator.service.impl;

import org.training.calculator.operations.math.Operations;
import org.training.calculator.service.Calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.stream.Stream;

import static org.training.calculator.constants.CalculatorConstants.*;

public class MathCalculator implements Calculator {

    private Operations operations;
    private NumberFormat numberFormat;

    public MathCalculator(Operations operations) {
        this.operations = operations;
        this.numberFormat = new DecimalFormat(DECIMAL_CONDITION);
    }

    public String calculate(String input) {
        String[] calculation = input.split(SPLIT_NUMBERS);
        double[] numbers = Stream.of(input.split(SPLIT_OPERATIONS)).mapToDouble(Double::parseDouble).toArray();
        int length = calculation.length;
        int index = 1;
        while (index < length) {
            if (MULTIPLE.equals(calculation[index])) {
                numbers[index - 1] = operations.multiple(numbers[index - 1], numbers[index]);
                length = checkNext(index, length, numbers, calculation);
            } else if (DIVIDE.equals(calculation[index])) {
                numbers[index - 1] = operations.divide(numbers[index - 1], numbers[index]);
                length = checkNext(index, length, numbers, calculation);
            } else {
                index++;
            }
        }
        index = 1;
        while (index < length) {
            if (PLUS.equals(calculation[index])) {
                numbers[index - 1] = operations.plus(numbers[index - 1], numbers[index]);
                length = checkNext(index, length, numbers, calculation);
            } else if (MINUS.equals(calculation[index])) {
                numbers[index - 1] = operations.minus(numbers[index - 1], numbers[index]);
                length = checkNext(index, length, numbers, calculation);
            } else {
                index++;
            }
        }
        return String.valueOf(numberFormat.format(numbers[0]));
    }

    private static int checkNext(int index, int length, double[] numbers, String[] operations) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
        }
        return length - 1;
    }

}