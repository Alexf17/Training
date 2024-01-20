package org.example._2024_01_18_morning;

import java.util.Arrays;
import java.util.List;

public class FMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("mama", "mila", "ramu");
        List<String> chars = list.stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .toList();
//        System.out.println(chars);

        List<List<Integer>> listN = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6), Arrays.asList(7, 8));
        listN.stream()
                .flatMap(arr -> arr.stream())
                .filter(e -> e % 2 != 0)
                .forEach(System.out::println);

        List<Integer> listI = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listJ = Arrays.asList(6, 7, 8, 9, 10);

        List<Integer> sumList = listI.stream()
                .flatMap(a ->
                        listJ.stream().map(b -> a + b))
                .toList();
    }
}
