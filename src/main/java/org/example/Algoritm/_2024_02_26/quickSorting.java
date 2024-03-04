package org.example.Algoritm._2024_02_26;

import java.util.ArrayList;
import java.util.List;

public class quickSorting {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(1,8,6,2,4,7,3,9,5));
        System.out.println(quickSort(array));

    }
    public static ArrayList<Integer> quickSort (ArrayList<Integer>arr){
if(arr.size()<=1){
    return arr;
}
        int lastEl = arr.get(arr.size()-1);
       ArrayList<Integer> left = new ArrayList<>();
       ArrayList<Integer> right = new ArrayList<>();

        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i)>lastEl){
                right.add(arr.get(i));
            } else {
                left.add(arr.get(i));
            }
        }
        ArrayList<Integer> newList = new ArrayList<>();
        newList.addAll(quickSort(left));
        newList.add(lastEl);
        newList.addAll(quickSort(right));

        return  newList;
    }
}
