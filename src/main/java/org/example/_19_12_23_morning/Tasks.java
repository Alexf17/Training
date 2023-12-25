package org.example._19_12_23_morning;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class Tasks {

    // HashMap<String, String>: Найдите количество пар ключ-значение, где длина ключа равна длине значения.
    public static int getCountOfPairs(HashMap<String, String> map) {
        int count = 0;
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().length() == entry.getValue().length()) {
                count++;
            }
        }
        return count;
    }

    //    HashMap<String, Integer>: Подсчитайте сумму всех значений, соответствующих ключам, начинающимся на букву 'A'.
    public static int getSumStartsA(HashMap<String, Integer> map) {
        int count = 0;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith("A")) {
                count++;
            }
        }
        return count;
    }

    //    HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка,
//    которые начинаются с гласной буквы.
    public static void getAllStringStartsFromVowel(HashMap<Integer, List<String>> map) {
        for (HashMap.Entry<Integer, List<String>> entry : map.entrySet()) {
            boolean isVowel = false;
            List<String> vowel = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (isStartsFromVowel(entry.getValue().get(i))) {
                    vowel.add(entry.getValue().get(i));
                    isVowel = true;
                }
            }
            if (isVowel) {
                System.out.println("key " + entry.getKey() + " contains: " + vowel);
            }
        }

    }

    private static boolean isStartsFromVowel(String str) {

        char firstChar = str.toLowerCase().charAt(0);
        if (firstChar == 'a' || firstChar == 'o' || firstChar == 'e' || firstChar == 'u' ||
                firstChar == 'y' || firstChar == 'i') {
            return true;
        }
        return false;
    }

    //    HashMap<Integer, Integer>: Найдите ключ с максимальным значением и выведите эту пару.
    public static void findMaxKey(HashMap<Integer, Integer> map) {
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println("Key: " + entry.getKey() + " contains max value: " + maxValue);
            }
        }
    }

    //    HashMap<String, String>: Определите, содержит ли HashMap такую пару ключ-значение, где ключ является обратной строкой
//    значения (например, ключ "abc", значение "cba").
    public static boolean isPalindrome(HashMap<String, String> map) {
        boolean hasPalindrome = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            StringBuilder value = new StringBuilder(entry.getValue()).reverse();
            if (entry.getKey().contentEquals(value)) {
                hasPalindrome = true;
            }
        }
        return hasPalindrome;
    }

    //    HashMap<String, Integer>: Переберите HashMap и преобразуйте его в HashMap<String, String>,
//    где каждое значение - это строковое представление исходного числа, умноженного на 2.
    public static HashMap<String, String> getNewMap(HashMap<String, Integer> map) {
        HashMap<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String value = Integer.toString(entry.getValue() * 2);
            newMap.put(entry.getKey(), value);
        }
        return newMap;
    }

    //    HashMap<Integer, List<String>>: Создайте второй HashMap<Integer, Integer>,
//    где каждый ключ - это ключ из исходного HashMap, а значение - общее количество символов во всех строках списка этого ключа.
    public static HashMap<Integer, Integer> getNewIntMap(HashMap<Integer, List<String>> map) {
        HashMap<Integer, Integer> newIntMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int length = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                length += entry.getValue().get(i).length();
                newIntMap.put(entry.getKey(), length);
            }

        }
        return newIntMap;
    }

    //    HashMap<Integer, Integer>: Найдите все пары ключ-значение, где ключ минус значение является простым числом.
    public static void getPrimePairs(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey() - entry.getValue();
            if (number <= 1) continue;
            boolean isPrime = true;
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) System.out.println(entry.getKey());
        }
    }

    //    HashMap<String, String>: Определите, можно ли преобразовать HashMap в List<String>,
//    где каждый элемент - это конкатенация ключа и значения, так, чтобы все элементы списка были уникальными.
    public static boolean checkMap(HashMap<String, String> map) {
        List<String> newList = new ArrayList<>();
        boolean possibility = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String newString = entry.getKey() + entry.getValue();
            if (!newList.contains(newString)) {
                newList.add(newString);
            } else {
                possibility = false;
            }
        }
        return possibility;
    }

    //    HashMap<String, Integer> и HashMap<Integer, List<String>>: Для каждого ключа в HashMap<String, Integer>
//    найдите соответствующие строки в HashMap<Integer, List<String>>,
//    где ключ во втором HashMap - это значение из первого, и выведите их.
    public static void getMixin(HashMap<String, Integer> map, HashMap<Integer, List<String>> list) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            for (Map.Entry<Integer, List<String>> listEntry : list.entrySet()) {
                List<String> value = listEntry.getValue();
                for (int i = 0; i < value.size(); i++) {
                    if (entry.getKey().equals(value.get(i))) {
                        System.out.println(entry);
                    }
                }
            }

        }
    }
}
