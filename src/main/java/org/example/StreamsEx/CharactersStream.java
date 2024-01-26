package org.example.StreamsEx;

import java.util.*;

public class CharactersStream {
    public static void main(String[] args) {
        List<Character> list = Arrays.asList('A', 'B', 'd', 'C', 'd', 'A');

        System.out.println(convertToStringList(list));
        System.out.println(filterByAsciiValue(list, 100));
        System.out.println(areAllUpperCase(list));
        System.out.println(findFirstDuplicate(list));
        System.out.println(reverseList(list));
    }

    //        11. Задача: Преобразование списка символов в список строк.
//        Сигнатура: List<String> convertToStringList(List<Character> input);
    public static List<String> convertToStringList(List<Character> input) {
        return input.stream().map(e -> e.toString()).toList();
    }

    //    12. Задача: Фильтрация символов по ASCII-значению.
//            Сигнатура: List<Character> filterByAsciiValue(List<Character> input, int ascii);
    public static List<Character> filterByAsciiValue(List<Character> input, int ascii) {
        return input.stream().filter(e -> e.charValue() == ascii).toList();
    }

    //    13. Задача: Проверка, все ли символы в списке заглавные.
//    Сигнатура: boolean areAllUpperCase(List<Character> input);
    public static boolean areAllUpperCase(List<Character> input) {
//        return input.stream().allMatch(Character::isUpperCase);
        return input.stream().allMatch(e -> e.toString().equals(e.toString().toUpperCase()));
    }

    //  !!!  14. Задача: Найти первый повторяющийся символ.
//    Сигнатура: Optional<Character> findFirstDuplicate(List<Character> input);
    public static Optional<Character> findFirstDuplicate(List<Character> input) {
        Set<Character> chars = new HashSet<Character>();
        return input.stream().filter(character -> input.indexOf(character) != input.lastIndexOf(character)).findFirst();
//        return input.stream().filter(e -> !chars.add(e)).findFirst();

    }

    // !!!   15. Задача: Получить обратный список символов.
//    Сигнатура: List<Character> reverseList(List<Character> input);
    public static List<Character> reverseList(List<Character> input) {
        Collections.reverse(input);
        return input;
//        return input.stream().sorted(Collections.reverseOrder()).toList();
    }
}
