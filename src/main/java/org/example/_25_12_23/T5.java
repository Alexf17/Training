package org.example._25_12_23;

public class T5 {
    public static void main(String[] args) {
        met(str -> System.out.println(str),"hi");

    }
    public static void met(Logger logger, String str){
        logger.log(str);
    }
}
//    Создайте функциональный интерфейс Logger с методом log, который принимает строку и выводит её в консоль.
//        Напишите метод, который использует Logger для логирования различных сообщений.
@FunctionalInterface
interface Logger {
    void log(String str);
    int hashCode();
}