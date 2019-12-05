package org.training.calculator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Ui ui = new Ui();
        Calculate calculate = new MathOperations();
        ui.init(calculate);
    }
}

