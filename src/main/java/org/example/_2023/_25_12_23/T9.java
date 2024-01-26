package org.example._2023._25_12_23;

import java.util.Arrays;

public class T9 {
    public static void main(String[] args) {
int [] numbers = {1,2,3,4,5,6,7,8};
met(arr ->{
    for (int i = 0; i < arr.length; i++){
        arr[i] = (arr[i]*-1);
    }
    System.out.println(Arrays.toString(arr));
}, numbers);
    }
    public static void met(NumberProcessor numberProcessor,int[] array){
        numberProcessor.process(array);
    }
}
//    Создайте функциональный интерфейс NumberProcessor с методом process, который выполняет операцию над массивом чисел.
//    Напишите метод, который принимает массив чисел и NumberProcessor, и возвращает массив после умножения каждого элемента на -1

@FunctionalInterface
interface NumberProcessor{
    void process(int[]numbers);
}