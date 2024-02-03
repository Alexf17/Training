package org.example.Algoritm._2024_01_29;

import java.util.Arrays;

public class StoneSort {
    public static void main(String[] args) {
        int[] arr = {1,7,5,4,3,2};

        for (int i = 0; i < arr.length-1; i++) {

            for (int j = arr.length-2; j >=i; j--) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
