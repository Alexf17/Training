package org.example.StreamsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FloatStream {
    public static void main(String[] args) {
        List<Float> list = Arrays.asList(1.2f, 2.3f, 3.4f, 4.5f, 0.7f);
        System.out.println(findMin(list));
        System.out.println(multiplyBy(list, 2));
        System.out.println(filterLessThan(list, 3));
        System.out.println(containsNegative(list));
        System.out.println(roundNumbers(list));
    }

    //    16. Задача: Найти минимальное число в списке.
//            Сигнатура: Optional<Float> findMin(List<Float> input);
    public static Optional<Float> findMin(List<Float> input) {
        return input.stream().min(Float::compareTo);
    }

    //    17. Задача: Получить список чисел, умноженных на заданное число.
//    Сигнатура: List<Float> multiplyBy(List<Float> input, float multiplier);
    public static List<Float> multiplyBy(List<Float> input, float multiplier) {
        return input.stream().map(e -> e * multiplier).toList();
    }

    //    18. Задача: Отфильтровать числа, меньшие заданного значения.
//    Сигнатура: List<Float> filterLessThan(List<Float> input, float value);
    public static List<Float> filterLessThan(List<Float> input, float value) {
        return input.stream().filter(e -> e < value).toList();
    }

    //    19. Задача: Проверить, содержит ли список отрицательные числа.
//            Сигнатура: boolean containsNegative(List<Float> input);
    public static boolean containsNegative(List<Float> input) {
        return input.stream().anyMatch(e -> e < 0);
    }

    //    20. Задача: Округление всех чисел в списке до ближайшего целого.
//    Сигнатура: List<Integer> roundNumbers(List<Float> input);
    public static List<Integer> roundNumbers(List<Float> input) {
        return input.stream().map(e -> Math.round(e)).toList();
//        return input.stream().map(Math::round).toList();
    }

}
