package org.example._2024_02_06_morning;

import org.example.TESTING._2024_02_06_morning.Taski;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskiTest {
    private static final Taski TASKI = new Taski();
    @Test
    void addTest() {
        int expected =5;
        int actual = TASKI.add(2, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractTest() {
        int expected =5;
        int actual =TASKI.subtract(8,3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplyTest() {
        int expected =12;
        int actual =TASKI.multiply(4,3);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void multiplyWithZeroTest() {
        int expected =0;
        int actual =TASKI.multiply(4,0);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void divideTest() {
        int expected =2;
        int actual =TASKI.divide(4,2);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void divideByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, ()->TASKI.divide(4,0));
    }

    @Test
    void powerTest() {
        int expected =16;
        double actual =TASKI.power(4,2);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void powerOnZeroTest() {
        int expected =1;
        double actual =TASKI.power(4,0);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void factorialTest() {
        int expected = 24;
        int actual =TASKI.factorial(4);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void factorialOfOneTest() {
        int expected =1;
        int actual =TASKI.factorial(1);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void factorialOfZeroTest() {
        int expected =1;
        int actual =TASKI.factorial(0);
    }
    @Test
    void factorialOfNegativeNumberTest() {
        Assertions.assertThrows(ArithmeticException.class, ()->TASKI.factorial(-2));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(10,TASKI.absolute(-10));
        Assertions.assertEquals(10,TASKI.absolute(10));
    }


    @Test
    void sqrtTest() {
        Assertions.assertEquals(4,TASKI.sqrt(16));
        Assertions.assertEquals(0,TASKI.sqrt(0));
    }

    @Test
    void logarithmTest() {
        Assertions.assertEquals(2, TASKI.logarithm(10,100));
    }
    @Test
    void logarithmWithNegativeOrZeroInBaseTest() {
        Assertions.assertThrows(ArithmeticException.class, ()->TASKI.logarithm(0,5));
        Assertions.assertThrows(ArithmeticException.class, ()->TASKI.logarithm(-1,5));
    }
    @Test
    void logarithmWithOneInBaseTest() {
        Assertions.assertEquals(0,TASKI.logarithm(1,5));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(0.841,TASKI.sin(1),0.001);
    }
}