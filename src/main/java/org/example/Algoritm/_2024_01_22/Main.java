package org.example.Algoritm._2024_01_22;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 2, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        getSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getSort(int[] arr) {
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero++;
            } else if (arr[i] == 1) {
                countOne++;
            }
        }
        for (int i = 0; i < countZero; i++) {
            arr[i] = 0;
        }
        for (int i = countZero; i < countOne + countZero; i++) {
            arr[i] = 1;
        }
        for (int i = countOne + countZero; i < arr.length; i++) {
            arr[i] = 2;
        }
    }
}
