package org.example._2024_02_06_morning;

import org.example.TESTING._2024_02_06_morning.ABC1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ABC1Test {
    private static final ABC1 OBJECT = new ABC1();
    private static final int expected = 10;

    @Test
    void sumTest() {
        int actual = OBJECT.sum(8, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void dividePositiveTest() {
        int actual = OBJECT.divide(100, 10);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> OBJECT.divide(10, 0));
    }
}