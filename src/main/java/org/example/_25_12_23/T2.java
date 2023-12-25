package org.example._25_12_23;

public class T2 {
    public static void main(String[] args) {
met( (a,b) ->a+b, 11,12);
    }
    public static void met(NumberOperation numberOperation, int a , int b){
        System.out.println(numberOperation.operate(a,b));

    }
}
//    Создайте функциональный интерфейс NumberOperation с методом operate, который принимает два целых числа и
//    возвращает целое число.
//    Напишите методы для выполнения базовых арифметических операций (сложение, вычитание, умножение, деление)
//    с использованием этого интерфейса.

@FunctionalInterface
interface NumberOperation {
    int operate(int a, int b);
    int hashCode();
}
