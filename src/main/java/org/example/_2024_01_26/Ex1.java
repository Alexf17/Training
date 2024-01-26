package org.example._2024_01_26;

public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {1, 2,2,1,3};
        int xor = 0;
        for(int x:arr) {
            xor ^=x;
        }
        System.out.println(xor);
    }
}
