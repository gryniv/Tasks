package org.training.calculator;

import java.util.stream.Stream;

import static org.training.calculator.CalculatorConstants.SPLIT_OPERATIONS_CONDITION;

public class TextToDoubleConverter implements Converter {

    public double[] convert(String input) {

        return Stream.of(input.split(SPLIT_OPERATIONS_CONDITION)).mapToDouble(Double::parseDouble).toArray();
    }
}
