package org.training.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter an expression: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println(calculate(input));
    }

    private static int[] convertToInt(String input) {
        String[] numbers = input.split("[" + Pattern.quote("+-*/") + "]");
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.parseInt(numbers[i]);
        }
        return numbersConverted;
    }

    private static int checkNext(int index, int length, int[] numbers, String[] operations) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
        }
        return length - 1;
    }

    private static int calculate(String input) {
        String[] operations = input.split("[0-9]+");
        int[] numbers = convertToInt(input);
        int length = operations.length;
        int index = 1;

        while (index < length) {
            if ("*".equals(operations[index])) { // NEM!!! "*" == operations[i]
                numbers[index - 1] *= numbers[index];
                length = checkNext(index, length, numbers, operations);
            } else if ("/".equals(operations[index])) { // NEM!!! "/" == operations[i]
                numbers[index - 1] /= numbers[index];
                length = checkNext(index, length, numbers, operations);
            } else {
                index++;
            }
        }
        index = 1;
        while (index < length) {
            if ("+".equals(operations[index])) { // NEM!!! "+" == operations[i]
                numbers[index - 1] += numbers[index];
                length = checkNext(index, length, numbers, operations);
            } else if ("-".equals(operations[index])) { // NEM!!! "-" == operations[i]
                numbers[index - 1] -= numbers[index];
                length = checkNext(index, length, numbers, operations);
            } else {
                index++;
            }
        }
        return numbers[0];
    }
}

