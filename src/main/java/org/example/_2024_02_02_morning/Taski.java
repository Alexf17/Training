package org.example._2024_02_02_morning;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Taski {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> mapData = creatMap();
//        System.out.println(getCharacterMap(mapData));
//        System.out.println(getMoreUsefulCharacter(mapData));
        System.out.println(getNumbersList(mapData));
//        System.out.println(getGroupingByName(mapData));
//        System.out.println(getUniqueSurname(mapData));
//        System.out.println(getSortedNames(mapData));
//        System.out.println(getNewFormat(mapData));
//        System.out.println(getAverageLengthOfName(mapData));
//        System.out.println(getMapOfNumbers(mapData));
//        System.out.println(getMaxMinNames(mapData));


    }

    public static Map<String, String> creatMap() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            Map<String, String> map = reader.lines().collect(Collectors.toMap(e -> e.split(" - ")[0], e -> e.split(" - ")[1]));
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // - Метод для создания мапы, где ключ - первая буква имени, а значение - количество таких имен
    public static Map<Character, Long> getCharacterMap(Map<String, String> mapData) {
        return mapData.values().stream().map(e -> e.charAt(0))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    // - Метод для нахождения самой часто встречающейся первой буквы в именах
    public static Character getMoreUsefulCharacter(Map<String, String> mapData) {

        return mapData.values().stream().map(e -> e.charAt(0))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse(' ');
    }

    // - Метод для создания списка номеров телефонов, где каждый номер преобразован в числовой формат
    public static List<Long> getNumbersList(Map<String, String> mapData) {
        return mapData.keySet().stream().map(e -> Long.parseLong(e.replaceAll("[^0-9+]", ""))).toList();
    }

    // - Метод для группировки имен по длине имени
    public static Map<Integer, List<String>> getGroupingByName(Map<String, String> mapData) {
        return mapData.values().stream().map(e -> {
            String[] parts = e.split("\\.\\s");
            return parts.length > 1 ? parts[1].split(" ")[0] : parts[0].split(" ")[0];
        }).collect(Collectors.groupingBy(e -> e.length()));
    }
// - Метод для поиска уникальных фамилий

    public static List<String> getUniqueSurname(Map<String, String> mapData) {
        return mapData.values().stream().map(e -> {
                    String[] parts = e.split("\\.\\s");
                    return parts.length > 1 ? parts[1].split(" ")[1] : parts[0].split(" ")[1];
                })
                .collect(Collectors.groupingBy(String::valueOf))
                .values().stream().filter(e -> e.size() == 1)
                .map(e -> e.toString()).toList();
    }

    // - Метод для создания списка имен, отсортированного в обратном алфавитном порядке
    public static List<String> getSortedNames(Map<String, String> mapData) {
        return mapData.values().stream().map(e -> {
                    String[] parts = e.split("\\.\\s");
                    return parts.length > 1 ? parts[1].split(" ")[0] : parts[0].split(" ")[0];
                })
                .collect(Collectors.groupingBy(String::valueOf))
                .values().stream().flatMap(e -> e.stream()).sorted(Comparator.comparing(String::valueOf).reversed())
                .toList();
    }

    // - Метод для преобразования данных в формат имя=номер
    public static Map<String, String> getNewFormat(Map<String, String> mapData) {
        return mapData.entrySet().stream().collect(Collectors.toMap(e -> {
            String[] parts = e.getValue().split("\\.\\s");
            return parts.length > 1 ? parts[1].split(" ")[0] : parts[0].split(" ")[0];
        }, e -> e.getKey(), (s, a) -> s + ", " + a));
    }

    // - Метод для расчета средней длины имени
    public static double getAverageLengthOfName(Map<String, String> mapData) {
        return mapData.values().stream().map(e -> e.split(" ")[0]).mapToInt(String::length).average().orElse(0);
    }

    // - Метод для создания карты, где ключ - номер телефона, а значение - имя
    public static Map<String, String> getMapOfNumbers(Map<String, String> mapData) {
        return mapData.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().split(" ")[0]));
    }

    // - Метод для поиска контактов с максимальной и минимальной длиной имени
    public static String getMaxMinNames(Map<String, String> mapData) {
        Map<String, String> data = new HashMap<>(mapData);

        List<String> max = data.values().stream()
                .map(e -> e.split(" ")[0])
                .collect(Collectors.groupingBy(e -> e.length())).entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getKey())).map(e -> e.getValue()).orElse(null);

        List<String> min = data.values().stream().map(e -> {
                    String[] parts = e.split("\\.\\s");
                    return parts.length > 1 ? parts[1].split(" ")[0] : parts[0].split(" ")[0];
                }).collect(Collectors.groupingBy(e -> e.length())).entrySet().stream()
                .min(Comparator.comparingInt(e -> e.getKey())).map(e -> e.getValue()).orElse(null);

        return "shorts names: " + min + "\n" + "longest names: " + max;
    }
}
