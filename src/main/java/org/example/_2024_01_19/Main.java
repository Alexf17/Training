package org.example._2024_01_19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lid = Arrays.asList(1, 2, 3, 4);
        System.out.println(lid.stream().min(Comparator.comparingInt(e -> e)).get());
    }

}
