package org.example._2024_01_09_morning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Stream3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(el -> {
            if (el.startsWith("w")) {
                el = el.toUpperCase();
                System.out.println("!!!");
            }

        return el;}).collect(Collectors.toList());
    }
}
