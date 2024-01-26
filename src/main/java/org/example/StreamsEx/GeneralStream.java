package org.example.StreamsEx;

import java.util.*;
import java.util.stream.Collectors;

public class GeneralStream {
    public static void main(String[] args) {

    }

    //21. Задача: Найти количество уникальных элементов в списке.
//    Сигнатура: <T> long countUnique(List<T> input);
    public static <T> long countUnique(List<T> input) {
        Set<T> uniqSet = new HashSet<>();
        return input.stream().filter(e -> uniqSet.add(e)).count();
//        return input.stream().filter(uniqSet::add).count();
    }

//22. Задача: Определить, является ли список отсортированным.
//    Сигнатура: <T extends Comparable<T>> boolean isSorted(List<T> input);
    public static <T extends Comparable<T>> boolean isSorted(List<T> input){
        return input.stream().sorted().equals(input);
    }

//23. Задача: Получить последний элемент списка, если он существует.
//    Сигнатура: <T> Optional<T> getLastElement(List<T> input);
    public static <T> Optional<T> getLastElement(List<T> input){
return input.stream().reduce((first,second)->second);
    }

//24. Задача: Перемешать элементы списка.
//            Сигнатура: <T> List<T> shuffleList(List<T> input);
public static <T> List<T> shuffleList(List<T> input){
return input.stream()
        .collect(Collectors.collectingAndThen(Collectors.toList(),e->{
            Collections.shuffle(e);
            return e;
        }));
}

//25. Задача: Подсчитать частоту каждого элемента в списке.
//    Сигнатура: <T> Map<T, Long> countFrequency(List<T> input);
    public static <T> Map<T, Long> countFrequency(List<T> input){
        return input.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
    }
}
