package org.example._25_12_23;

import java.sql.Array;
import java.util.Arrays;

public class T6 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
met(element->{
    for (int i = 0; i<numbers.length; i++){
        numbers[i] = numbers[i]*numbers[i];
    }
    System.out.println(Arrays.toString(numbers));
} , numbers);
    }
    public static void met(ArrayTransformer arrayTransformer,int[]array){
        arrayTransformer.transform(array);
    }
}
//    Создайте функциональный интерфейс ArrayTransformer с методом transform, который принимает массив
//        целых чисел и выполняет операцию возведения каждого элемента в квадрат.
//        Напишите метод, который принимает массив и ArrayTransformer, и изменяет массив, возведя каждый его элемент в квадрат.
@FunctionalInterface
interface ArrayTransformer {
    void transform(int[] array);
    int hashCode();
}