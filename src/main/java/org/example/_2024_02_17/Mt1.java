package org.example._2024_02_17;

public class Mt1 {
    public static void main(String[] args) {
        Th1 t1 = new Th1();
        Th2 t2 = new Th2();
        t1.start();
        t2.start();
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(i + " i ");
//        }


    }
}

class Th1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " T1i ");
        }
    }
}

class Th2 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i + " T2i ");
        }
    }
}