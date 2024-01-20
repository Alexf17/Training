package org.example._2024_01_16_morning;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
//        System.out.println(exists("LLRR"));
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int count = 7;
//        System.out.println(hasSum(array,count));
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
//        System.out.println(fin(arr));
        int[] arr2 = {0, 1, 2, 4, 9, 3, 5, 6, 8};
        System.out.println(getNum(arr2));
    }
    public static int getNum (int[] arr) {
        int sumArr=0;
        int sumTemp=0;

        for (int i : arr) {
            sumArr += i;
            if(i<=arr.length){
                sumTemp +=arr[i];
            }

        }

//        for (int i = 0; i < arr.length; i++) {
//            sumArr += arr[i];
//
//        }
//        for (int i = 0; i <=arr.length ; i++) {
//            sumTemp += i;
//        }

//        return Math.abs(sumArr-sumTemp) ;
        return sumArr - sumTemp ;
    }



    public static List<Integer> fin(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                if (array.get(i).equals(array.get(j))) {
                    array.remove(j);
                    j--;
                }
            }

        }
        return array;
    }

    public static List<int[][]> attack(int[][] KingCoord, int[][] qeens) {
        return null;
    }

    public static boolean hasSum(int[] array, int k) {
        int start = 0;
        int finish = array.length - 1;
        while (start != finish) {
            int sum = array[start] + array[finish];
            if (k == sum) {
                System.out.println(array[start] + " + " + array[finish]);
                return true;
            } else if (k > sum) {
                start++;
            } else {
                finish--;
            }
        }
        return false;
    }

    public static boolean exists(String str) {
        int l = 0;
        int u = 0;
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'L' -> l++;
                case 'R' -> l--;
                case 'U' -> u++;
                case 'D' -> u--;
            }
        }
        return l == 0 && u == 0;
    }
}
