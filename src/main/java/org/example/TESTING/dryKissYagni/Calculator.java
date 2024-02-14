package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Нарушение KISS:
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }
}

class CalculatorI {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }


}
class CalculatorITest{
    @Test
    void addTest() {
        Assertions.assertEquals(5, CalculatorI.add(2, 3));
    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(4, CalculatorI.subtract(6, 2));
    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(12, CalculatorI.multiply(2, 6));
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(1.5, CalculatorI.divide(3, 2));
    }

    @Test
    void divideWithZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> CalculatorI.divide(4, 0));
    }

}