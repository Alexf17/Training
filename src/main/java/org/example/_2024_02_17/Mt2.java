package org.example._2024_02_17;

public class Mt2 {
    public static void main(String[] args) {
        Thread T1 = new Thread(new TH1());
        Thread T2 = new Thread(new TH2());

        T1.start();
        T2.start();
    }

}

class TH1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " T1i ");
        }
    }
}

class TH2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " T2i ");
        }
    }
}
