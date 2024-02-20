package org.example.Algoritm._2024_02_19;

import java.util.Arrays;

public class Alg {
    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 7, 8, 9, 10};
        int[] list2 = {2, 4, 6, 12};
        int[] list = {1,7,6,4,3,8,2,0};
        System.out.println(Arrays.toString(merg(list)));

//        System.out.println(Arrays.toString(sorting(list1, list2)));
    }

    public static int[] merg(int[]list){
        if(list.length<=1)return list;
        int[]left = Arrays.copyOfRange(list,0,list.length/2);
        int[]right = Arrays.copyOfRange(list,list.length/2,list.length);
        return sorting(merg(left),merg(right));

    }

    public static int[] sorting(int[] list1, int[] list2) {
        int[] newList = new int[list1.length+list2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < list1.length && index2 < list2.length) {
            if (list1[index1] < list2[index2]) {
                newList[index] = list1[index1];
                index++;
                index1++;
            } else {
                newList[index] = list2[index2];
                index++;
                index2++;
            }
        }
        while (index1 < list1.length) {
            newList[index] = list1[index1];
            index++;
            index1++;
        }
        while (index2 < list2.length) {
            newList[index] = list2[index2];
            index++;
            index2++;
        }
      return newList;
    }
}
