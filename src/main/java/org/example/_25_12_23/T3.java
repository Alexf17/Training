package org.example._25_12_23;

import java.util.Optional;

public class T3 {
    public static void main(String[] args) {
//        met((a,b) ->{ Optional<Double> i =i =b==0 ? Optional.of(double)(0): Optional.of(double)(a/b)  return i} ,10,2);
        met((a,b) ->{
            if(b==0) return Optional.empty();
            else return Optional.of((double) a/b);
        },10,2);
    }
    public static Optional<Double> met(SafeDivision safeDivision , int a, int b){
     return safeDivision.divide(a,b);
    }
//    Создайте функциональный интерфейс SafeDivision с методом divide, который безопасно делит два числа и возвращает Optional<Double>.
//    Реализуйте метод, который делит два числа с использованием SafeDivision, обрабатывая случай деления на ноль.
}
@FunctionalInterface
interface SafeDivision {
    Optional<Double> divide(int a, int b);
    int hashCode();
}