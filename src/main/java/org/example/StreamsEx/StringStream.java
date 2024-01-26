package org.example.StreamsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        String[][] arrStr = {{"a,b,c"}, {"d", "e", "f"}};
        List<String> stringList = Arrays.asList("a", "b", "c", "asds", "dsfdsplg", "dfglfd", "df");
//        List<String> list = Arrays.stream(arrStr).flatMap(x->Arrays.stream(x)).collect(Collectors.toList());

        System.out.println(filterByLength(stringList, 3));
        System.out.println(toUpperCase(stringList));
        System.out.println(findFirstStartingWith(stringList, 'd'));
        System.out.println(joinByComma(stringList));
        System.out.println(countContainingChar(stringList, 'd'));
    }

    //    1. Задача: Фильтрация списка строк по длине.
//    Сигнатура: List<String> filterByLength(List<String> input, int length);
    public static List<String> filterByLength(List<String> input, int length) {
        return input.stream().filter(e -> e.length() > length).toList();
    }

    //    2. Задача: Преобразование всех строк в верхний регистр.
//    Сигнатура: List<String> toUpperCase(List<String> input);
    public static List<String> toUpperCase(List<String> input) {
        return input.stream().map(String::toUpperCase).toList();
    }

    //    3. Задача: Поиск первой строки, начинающейся на заданную букву.
//    Сигнатура: Optional<String> findFirstStartingWith(List<String> input, char letter);
    public static Optional<String> findFirstStartingWith(List<String> input, char letter) {
        return input.stream().filter(e -> e.startsWith(String.valueOf(letter))).findFirst();
    }

    //    4. Задача: Соединение строк через запятую.
//    Сигнатура: String joinByComma(List<String> input);
    public static String joinByComma(List<String> input) {
//        return String.join(",", input);
        return input.stream().collect(Collectors.joining(","));
    }

    //    5. Задача: Подсчёт количества строк, содержащих заданный символ.
//    Сигнатура: long countContainingChar(List<String> input, char ch);
    public static long countContainingChar(List<String> input, char ch) {
        return input.stream().filter(e -> e.contains(String.valueOf(ch))).count();
    }
}
