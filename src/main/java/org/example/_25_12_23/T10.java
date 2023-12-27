package org.example._25_12_23;

import java.util.Arrays;

import static java.lang.System.exit;
import static java.lang.System.in;

public class T10 {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8};
        int steps = 7;
met( (arr,step)->{
    if(step==arr.length){
        System.out.println("Its a length of array,the array will remain the same!");
        exit(1);
    }
    if(step>arr.length){
        System.out.println("Too big step, you out of array size!");
        exit(1);
    }
int[] newArray = new int [arr.length];
    for (int i = 0; i < arr.length; i++){
        int index = (i+ step)%arr.length;
        System.out.println(index);
        newArray[index]=arr[i];
    }
    System.out.println(Arrays.toString(newArray));

},numbers,steps);
    }
    public static void met(ArrayRotator arrayRotator,int [] numbers, int step){
        arrayRotator.rotate(numbers, step);
    }
}
//    Создайте функциональный интерфейс ArrayRotator с методом rotate, который выполняет циклический сдвиг элементов массива.
//    Напишите метод, который принимает массив и ArrayRotator и шаг сдвига, и выполняет сдвиг массива на заданную позицию влево.
@FunctionalInterface
interface ArrayRotator{
    void rotate(int[]numbers, int step);
}