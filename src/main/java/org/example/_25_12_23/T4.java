package org.example._25_12_23;

public class T4 {
    public static void main(String[] args) {
//        met(str -> str.toUpperCase(),"hello");
        met(String::toUpperCase,"hello");

    }
    public static void met (UpperCaseConverter upperCaseConverter,String string){
        System.out.println(upperCaseConverter.convert(string));
    }
//    Создайте функциональный интерфейс UpperCaseConverter с методом convert, который преобразует строку в верхний регистр.
//    Напишите метод, который принимает строку и UpperCaseConverter интерфейс, и преобразует её в верхний регистр.
}
@FunctionalInterface
interface UpperCaseConverter {
    String convert(String str);
    int hashCode();
}