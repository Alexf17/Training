package org.example._19_12_23_morning;

import java.util.*;

public class LearnMap {
    public static void main(String[] args) {

        HashMap<String, String> mapStrStr = new HashMap<>();
        mapStrStr.put("Ключ1", "Значение1");
        mapStrStr.put("Ключ2", "Значение2");
        mapStrStr.put("Ключ3", "Значение3");
        mapStrStr.put("Ключ4", "Значение4");
        mapStrStr.put("Ключ5", "Значение5");
        mapStrStr.put("null", "null");
        mapStrStr.put("abc", "cba");

        HashMap<Integer, String> mapIntStr = new HashMap<>();
        mapIntStr.put(1, "Значение1");
        mapIntStr.put(2, "Значение2");
        mapIntStr.put(3, "Значение3");
        mapIntStr.put(4, "Значение4");
        mapIntStr.put(5, "AЗначение5");
        mapIntStr.put(6, "null");

        HashMap<String, Integer> mapStrInt = new HashMap<>();
        mapStrInt.put("Значение1", 1);
        mapStrInt.put("Значение2", 2);
        mapStrInt.put("Значение3", 3);
        mapStrInt.put("Значение4", 4);
        mapStrInt.put("Alfa", 5);
        mapStrInt.put("null", 6);

        HashMap<Integer, Integer> mapIntInt = new HashMap<>();
        mapIntInt.put(1, 1);
        mapIntInt.put(3, 1);
        mapIntInt.put(4, 3);
        mapIntInt.put(10, 4);
        mapIntInt.put(7, 5);
        mapIntInt.put(0, 6);
        mapIntInt.put(9, 6);

        HashMap<Integer, List<String>> mapIntList = new HashMap<>();
        List<String> list1 = List.of("Alfa", "King","Between", "Better");
        List<String> list2 = List.of("Elephant", "null","More", "Lamp", "Empty");
        List<String> list3 = List.of("Omega", "Second","Apple", "Orange");
        mapIntList.put(1,list1);
        mapIntList.put(2,list2);
        mapIntList.put(3,list3);

//        System.out.println(Tasks.getCountOfPairs(mapStrStr));
//        System.out.println(Tasks.getSumStartsA(mapStrInt));
//        Tasks.getAllStringStartsFromVowel(mapIntList);
//        Tasks.findMaxKey(mapIntInt);
//        System.out.println(Tasks.isPalindrome(mapStrStr));
//        System.out.println(Tasks.getNewMap(mapStrInt));
//        System.out.println(Tasks.getNewIntMap(mapIntList));
//        Tasks.getPrimePairs(mapIntInt);
//        System.out.println(Tasks.checkMap(mapStrStr));
//        Tasks.getMixin(mapStrInt,mapIntList);
    }
}
