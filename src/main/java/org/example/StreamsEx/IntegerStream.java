package org.example.StreamsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IntegerStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(sumOfList(list));
        System.out.println(getSquares(list));
        System.out.println(filterGreaterThan(list, 3));
        System.out.println(containsNumber(list, 6));
        System.out.println(findMax(list));
    }

    //    6. Задача: Найти сумму всех чисел в списке.
//    Сигнатура: int sumOfList(List<Integer> input);
    public static int sumOfList(List<Integer> input) {
        return input.stream().mapToInt(i -> i).sum();
    }

    //    7. Задача: Получить список квадратов чисел.
//    Сигнатура: List<Integer> getSquares(List<Integer> input);
    public static List<Integer> getSquares(List<Integer> input) {
        return input.stream().map(e -> e * e).collect(Collectors.toList());
    }

    //    8. Задача: Фильтрация чисел, больших заданного значения.
//    Сигнатура: List<Integer> filterGreaterThan(List<Integer> input, int minValue);
    public static List<Integer> filterGreaterThan(List<Integer> input, int minValue) {
        return input.stream().filter(e -> e > minValue).collect(Collectors.toList());
    }

    //    9. Задача: Проверка, содержит ли список заданное число.
//    Сигнатура: boolean containsNumber(List<Integer> input, int number);
    public static boolean containsNumber(List<Integer> input, int number) {
        return input.stream().anyMatch(e -> e == number);
    }

    //    10. Задача: Найти максимальное число в списке.
//    Сигнатура: Optional<Integer> findMax(List<Integer> input);
    public static Optional<Integer> findMax(List<Integer> input) {
//        return input.stream().max((a,b)->a.compareTo(b));
        return input.stream().max(Integer::compareTo);

    }
}
