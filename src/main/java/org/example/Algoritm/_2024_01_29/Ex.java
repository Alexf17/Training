package org.example.Algoritm._2024_01_29;

public class Ex {
    public static void main(String[] args) {
        int[] numbers = {  3, 4, 5,6,8};
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        for (int i = 1; i <= numbers.length + 1; i++) {
            sum1 += i;
        }
        System.out.println(sum1-sum);

    }
}
