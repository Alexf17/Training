package org.example._15_12_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Task1 {
    public static void main(String[] args) {






        int capacity = 10;

        List<String> list = new ArrayList<>(capacity);
        List<Integer> numbers = new ArrayList<>(capacity);
        List<String[]> stringArray = new ArrayList<>(capacity);
        List<Integer[]> intArray = new ArrayList<>(capacity);
        List<Character> charList = new ArrayList<>(capacity);
        List<List<String>> stringList = new ArrayList<>(capacity);
        List<List<Integer>> intList = new ArrayList<>(capacity);

        Random random = new Random();

        for (int i = 0; i < capacity; i++) {
            String[] array = new String[random.nextInt(1, 7)];
            Integer[] intArr = new Integer[array.length];
            List<String> innerList = new ArrayList<>();
            List<Integer> innerListInt = new ArrayList<>();
            list.add("Element" + (i + 1));
            numbers.add(random.nextInt(1, 11));
            char index = (char) (i + 65);
            charList.add(index);
            for (int j = 0; j < array.length; j++) {
                array[j] = "Element " + i + "-" + j;
                intArr[j] = i * 5 + j;
                innerList.add("Element " + i + "-" + j);
                innerListInt.add(i * j);
            }
            stringList.add(innerList);
            stringArray.add(array);
            intList.add(innerListInt);
            intArray.add(intArr);
        }

//        printAllElements(list);
//        getCharCode(charList);
//        getSQR(numbers);
//        getFirstElInArr(stringArray);
//        printAllInclEl(stringList);
//        getEven(numbers);
//        getStringStartsFrom(list,"o");
//        getCountOfVowel(charList);
//        getLengthOfArray(stringArray);
//        getSumOfAllNumbers(intList);
//        getListWithSumMoreTen(intList);
//        getCountOfLongWords(list, 8);
//        getMaxNumber(intArray);
//        getAllCombinations(stringList);
//        getNumberWithSum(numbers);
//        getNewListWthUniqueElements(list);
//        getReverseList(charList);
//        getRepetitiveList(intList);
//        getAllSubsets(numbers);
        getAllIntComb(list);
//        getMaxSumList(intList);
//        getAllStrings(charList);
    }



    //        Перебор List<String> и вывод каждого элемента.
    public static void printAllElements(List<String> list) {
        for (String el : list) {
            System.out.println(el);
        }
    }

    //        Перебор List<Character> и вывод ASCII-кода каждого символа.
    public static void getCharCode(List<Character> list) {
        for (Character c : list) {
            System.out.println(c);
        }
    }

    //        Перебор List<Integer> и вывод квадратов каждого числа.
    public static void getSQR(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i * i);
        }
    }

    //        Перебор List<String[]> и вывод первого элемента каждого подмассива.
    public static void getFirstElInArr(List<String[]> arr) {
        for (String[] str : arr) {
            System.out.println(str[0]);
        }
    }

    //        Перебор List<List<String>> и вывод всех элементов вложенных списков.
    public static void printAllInclEl(List<List<String>> lists) {
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    //    Перебор List<Integer> и вывод только четных чисел.
    public static void getEven(List<Integer> list) {
        for (int i : list) {
            if (i == 0) {
                continue;
            } else if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    //    Перебор List<String> и вывод слов, начинающихся на определенную букву.
    public static void getStringStartsFrom(List<String> list, String letter) {
        for (String s : list) {
            if (s.toLowerCase().startsWith(letter.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    //    Перебор List<Character> и подсчет количества гласных.
    public static void getCountOfVowel(List<Character> list) {
        System.out.println(list);
        int count = 0;
        for (Character s : list) {
            String letter = s.toString().toLowerCase();
            if (letter.equals("a") || letter.equals("o") || letter.equals("e") || letter.equals("u") || letter.equals("y") || letter.equals("i"))
                ++count;
        }
        System.out.println("CountOfVowel: "+count);
    }

    //    Перебор List<String[]>, вывод длины каждого подмассива.
    public static void getLengthOfArray(List<String[]> list) {
        for (String[] arr : list) {
            System.out.println(arr.length);

        }
    }

    //    Перебор List<List<Integer>>, подсчет суммы всех чисел.
    public static void getSumOfAllNumbers(List<List<Integer>> lists) {
        int sum = 0;
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    //    Перебор List<List<Integer>> и вывод только тех списков, сумма элементов которых больше 10.
    public static void getListWithSumMoreTen(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            if (sum > 10) System.out.println("Summ in list " + list + " is " + sum);
        }
    }

    //    Перебор List<String> и подсчет количества слов определенной длины.
    public static void getCountOfLongWords(List<String> list, int length) {
        int count = 0;
        for (String word : list) {
            if (word.length() == length) ++count;

        }
        System.out.println(count);
    }

    //    Перебор List<Integer[]> и нахождение максимального элемента в каждом массиве.
    public static void getMaxNumber(List<Integer[]> list) {
        for (Integer[] arr : list) {
            int max = Integer.MIN_VALUE;
            for (Integer integer : arr) {
                if (integer > max) max = integer;
            }
            System.out.println(max);
        }
    }

    //    Перебор List<List<String>>, вывод всех комбинаций строк из разных вложенных списков.
    public static void getAllCombinations(List<List<String>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            List<String> parts = lists.get(i);
            for (int j = 0; j < parts.size(); j++) {
                String element = parts.get(j);
                for (int k = j + 1; k < parts.size(); k++) {
                    System.out.println(element + " + " + parts.get(k));
                }
            }
        }
    }

    //    Перебор List<Integer> и нахождение всех пар чисел, сумма которых равна 10.
    public static void getNumberWithSum(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) + list.get(i) == 10)
                    System.out.println("Sum of " + list.get(j) + " + " + list.get(i) + " equals 10");
            }
        }
        System.out.println(list);
    }

    //    Перебор List<String> и создание нового списка, содержащего только уникальные элементы.
    public static void getNewListWthUniqueElements(List<String> list) {
        List<String> newList = new ArrayList<String>();
        for (String str : list) {
            System.out.println(str);
            if (!newList.contains(str)) {
                newList.add(str);
            }
        }
        System.out.println(list);
        System.out.println(newList);
    }

    //    Перебор List<Character> и перестановка элементов в обратном порядке.
    public static void getReverseList(List<Character> list) {
        List<Character> newList = new ArrayList<Character>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        System.out.println(newList);
    }

    //    Перебор List<List<Integer>> и вывод тех вложенных списков, которые содержат повторяющиеся элементы.
    public static void getRepetitiveList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            boolean repetitive = false;
            for (int i = 0; i < list.size(); i++) {
                if (repetitive) continue;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) {
                        System.out.println("In List " + list + " we have repetitive numbers");
                        repetitive = true;
                        break;
                    }
                }
            }
        }
    }

    //    Перебор List<Integer> и нахождение всех подмножеств этого списка.
    public static void getAllSubsets(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                System.out.println(list.get(i) + " + " + list.get(j));
            }
        }
    }
//    Перебор List<String> и создание всех возможных комбинаций строк без повторений.
    public static void getAllIntComb(List<String> list){

    }

    //    Перебор List<List<Integer>> и нахождение списка с максимальной суммой элементов.
    public static void getMaxSumList(List<List<Integer>> lists) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < lists.size(); i++) {
            int sum = 0;
            for (int j = 0; j < lists.get(i).size(); j++) {
                sum += lists.get(i).get(j);
            }
            if (sum > max) {
                max = sum;
                index = i;
            }
        }
        System.out.println("max sum " + max + " in List " + lists.get(index));
    }

    //    Перебор List<Character> и построение всех возможных строк из данных символов.
    public static void getAllStrings(List<Character> list) {
        for (int i = 0; i < list.size()-1; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = i + 1; j < list.size(); j++) {
                str.append(list.get(i)).append(list.get(j));
            }
            System.out.println(str);
        }
    }
}
