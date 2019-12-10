package org.training.calculator;

import java.util.regex.Pattern;

public class TextToDoubleConverter implements Converter {

    public double[] convert(String input) {
        String[] numbers = input.split("[" + Pattern.quote("+-*/") + "]");
        double[] numbersConverted = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Double.parseDouble(numbers[i]);
        }
        return numbersConverted;
    }
}
