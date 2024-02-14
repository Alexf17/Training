package org.example._2024_02_06_morning;

import org.example.TESTING._2024_02_06_morning.ABC2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ABC2Test {
    private static final ABC2 ABC_2 = new ABC2();
    private static final String s1 = "1";
    private static final String s2 = "2";
    private static final String s3 = "3";

    @BeforeEach
    public void setUp() {
        ABC_2.getList().clear();
    }

    @Test
    void addToList() {
        ABC_2.addToList(s1);
        ABC_2.addToList(s2);
        ABC_2.addToList(s3);
        int expectedSize = 3;
        Assertions.assertEquals(expectedSize, ABC_2.getList().size());
    }

    @Test
    void modifyList() {
        ABC_2.addToList(s1);
        ABC_2.addToList(s2);
        ABC_2.addToList(s3);
        ABC_2.modifyList();
        List<String> modifiedList = Arrays.asList("1!", "2!", "3!");
        Assertions.assertEquals(modifiedList, ABC_2.getList());
    }
}