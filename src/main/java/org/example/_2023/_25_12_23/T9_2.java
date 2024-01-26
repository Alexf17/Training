package org.example._2023._25_12_23;

import java.util.Arrays;

public class T9_2 {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8};
        int[] result = met(numbers, (x) -> x * -1);
        System.out.println(Arrays.toString(result));
    }
    public static int[] met(int[] array,NumberProcessor2 numberProcessor){
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = numberProcessor.process(array[i]);
        }
        return result;
    }
}
//    Создайте функциональный интерфейс NumberProcessor с методом process, который выполняет операцию над массивом чисел.
//    Напишите метод, который принимает массив чисел и NumberProcessor, и возвращает массив после умножения каждого элемента на -1

@FunctionalInterface
interface NumberProcessor2{
    int process(int number);
}