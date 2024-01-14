package org.example._2024_01_09_morning;

public class Stream1 {
    public static void main(String[] args) {

//        m1(()-> System.out.println("Hello"));

        m1(Stream1::w1);
    }
    public static void m1(Printer printer){
        printer.get();
    }
    public static void w1(){
        System.out.println("@@@");
    }
}

@FunctionalInterface
interface Printer{
    void get();
}
