package org.training.calculator;

import java.util.regex.Pattern;

public class TextToIntConvector implements Convector {

    public int[] convert(String input) {
        String[] numbers = input.split("[" + Pattern.quote("+-*/") + "]");
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.parseInt(numbers[i]);
        }
        return numbersConverted;
    }
}
