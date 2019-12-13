package org.training.calculator.operations;

public interface Operations {

    /**
     * @return calculation numOne * numTwo
     */
    double multiple(double numOne, double numTwo);

    /**
     * @return calculation numOne / numTwo
     */
    double divide(double numOne, double numTwo);

    /**
     * @return calculation numOne + numTwo
     */
    double plus(double numOne, double numTwo);

    /**
     * @return calculation numOne - numTwo
     */
    double minus(double numOne, double numTwo);
}
