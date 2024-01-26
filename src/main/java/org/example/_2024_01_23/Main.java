package org.example._2024_01_23;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        get Sum
//        int sum = list.stream().mapToInt(Integer::intValue).sum();
//        OR
//        int sum1 = list.stream().reduce((x, y) -> x + y).orElse(0);

//=================

//        get Multiplication
//    int mult = list.stream().reduce((x, y) -> x * y).orElse(0);

//=================

//        reduce + accumulate
//    int sum = 0;
//    int s = list.stream().reduce(sum, (x, y) -> x + y);

// =================

//        reduce + acc + collector
        int sum = list.stream().reduce(0, (x, y) -> x + y, (s1, s2) -> s1 + s2);

        int sum2 = list.parallelStream().reduce(0, (x, y) -> x + y, (s1, s2) -> s1 + s2);

        int sum3 = list.stream().reduce(0, (x, y) -> {
            System.out.println(x + y);
            return x + y;
        }, (s1, s2) -> s1 + s2);

//        System.out.println(sum);
//        System.out.println(sum2);
        System.out.println(sum3);
    }
}
