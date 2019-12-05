package org.training.calculator;

public class MathOperations implements Calculate {

    public String calculate(String input) {
        String[] operations = input.split("[0-9]+");
        Convector convector = new TextToIntConvector();
        int[] numbers = convector.convert(input);
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
        return String.valueOf(numbers[0]);
    }

    private static int checkNext(int index, int length, int[] numbers, String[] operations) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
        }
        return length - 1;
    }


}