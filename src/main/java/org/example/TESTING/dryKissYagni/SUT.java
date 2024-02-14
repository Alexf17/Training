package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SUT {

    public static String toUpperCase1(String input) {
        return input.toUpperCase();
    }

    public static String toLowerCase2(String input) {
        return input.toLowerCase();
    }

    // Дублирование конвертации строки в массив символов
    public static char[] toCharArray2(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }
        return result;
    }
}

class SUTI {

    public static String toUpperCase1(String input) {
        return input.toUpperCase();
    }

    public static String toLowerCase2(String input) {
        return input.toLowerCase();
    }

    // Дублирование конвертации строки в массив символов
    public static char[] toCharArray2(String input) {
        return input.toCharArray();
    }
}
class SUTITest{
    @Test
    void toUpperCase1Test() {
    Assertions.assertEquals("HELLO",SUT.toUpperCase1("hElLo"));
    }
    @Test
    void toLowerCase2Test() {
    Assertions.assertEquals("hello",SUT.toLowerCase2("hElLo"));
    }
    @Test
    void toCharArray2Test() {
    Assertions.assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'},SUT.toCharArray2("hello"));
    }
}
