package org.example._25_12_23;

import java.util.Scanner;
import java.util.SortedMap;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first number");
        int first = scanner.nextInt();
        System.out.println("enter char");
        char symbol = scanner.next().charAt(0);
        System.out.println("enter second number");
        int second = scanner.nextInt();
        met((a, b, s ) ->{
            int sum = 0;
            switch (s){
                case '+'-> sum =a + b;
                case '-'-> sum =a-b;
                case '*'-> sum =a*b;
                case '/' -> {
                    if(b!=0) sum =a/b;else System.out.println("You cant divide for zero");
                }
                default -> System.out.println("you enter incorrect symbol");

            }
            return sum;
        }, first, second,symbol);
    }

    public static void met(NumberOperation numberOperation, int a, int b,char s) {
        System.out.println(numberOperation.operate(a, b,s));

    }
}
//    Создайте функциональный интерфейс NumberOperation с методом operate, который принимает два целых числа и
//    возвращает целое число.
//    Напишите методы для выполнения базовых арифметических операций (сложение, вычитание, умножение, деление)
//    с использованием этого интерфейса.

@FunctionalInterface
interface NumberOperation {
    int operate(int a, int b, char s);

    int hashCode();
}
