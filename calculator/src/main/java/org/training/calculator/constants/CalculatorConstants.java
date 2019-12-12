package org.training.calculator.constants;

import java.util.regex.Pattern;

public final class CalculatorConstants {

    private CalculatorConstants() {

    }

    public static final String DECIMAL_CONDITION = "#.#####";
    public static final String SPLIT_OPERATIONS = "[" + Pattern.quote("+-*/") + "]";
    public static final String SPLIT_NUMBERS = "\\d+\\.?\\d*";
    public static final String MULTIPLE = "*";
    public static final String DIVIDE = "/";
    public static final String MINUS = "-";
    public static final String PLUS = "+";

}