package org.example.Algoritm._2024_01_15;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10,9,11};
//        evenNum();
//        check(num);
//        checkNeg(num);
//        checkDouble(num);
        printAll(num);
    }
    public static void printAll(int[] num) {
        for (int i = 0; i <num.length-1;i++) {
            for (int j =i+1; j < num.length; j++) {
                System.out.println(num[i]+" : "+num[j]);
            }
        }
    }

    // при отсортированных даных и в конце один дубликат
    public static void checkDouble(int[] num) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i=1;i<num.length;i++){
            sum1=sum1+i;
        }
        for (int i=0;i<num.length;i++){
            sum2=sum2+num[i];
        }

        System.out.println(sum2-sum1);
        }


    public static void checkNeg(int[] num) {
        for (int i = 0; i <num.length;i++) {
            num[i] = num[i] +1;
        }
        System.out.println(Arrays.toString(num));
    }
    public static void check(int[] num) {
        for (int i = 0; i <num.length;i++) {
            if(num[i] > 0) {
                System.out.println(num[i]);
            }
        }
    }
    public static void evenNum() {
        for (int i = 1; i <=10;i++) {
            if(i%2 == 0) {
                System.out.println(i);
            }
        }
    }

}
