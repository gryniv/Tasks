package org.training.calculator;

import java.util.regex.Pattern;

final class CalculatorConstants {

    static final String SPLIT_OPERATIONS_CONDITION = "[" + Pattern.quote("+-*/") + "]";
    static final String SPLIT_NUMBERS_CONDITION = "\\d+\\.?\\d*";
    static final String DECIMAL_CONDITION = "#.#####";
    static final String MULTIPLE = "*";
    static final String DIVIDE = "/";
    static final String MINUS = "-";
    static final String PLUS = "+";

}