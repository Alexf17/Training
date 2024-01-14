package org.example._2024_01_09_morning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stream2 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3,3, 4,4, 5, 6,6, 7, 8, 9);
//        Set<Integer> set = new HashSet<Integer>();
        Set <Integer> set = new HashSet<Integer>(list);
        for (int i = 0; i < list.size();i++) {
            set.add(list.get(i));
        }
        int sum =0;
        for(Integer i : set) {
            if (i%2 == 0 && i>5) {
                sum += i;
            }
        }
        System.out.println(sum);

//        List<Integer> list = Arrays.asList(1, 2, 3,3, 4,4, 5, 6,6, 7, 8, 9);
//        int s = list.stream()
//                .distinct()  //оставляет только числа без дубликатов
//                .filter(el -> (el%2 == 0 && el >5)) //отбирает только четный больше 5
//                .reduce((acc, com)-> acc + com)
//                .get();


    }


}
