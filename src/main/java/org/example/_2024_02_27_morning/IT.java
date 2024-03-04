package org.example._2024_02_27_morning;

import lombok.SneakyThrows;

public class IT {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN START");

        ITExample thread = new ITExample();
        thread.start();

        Thread.sleep(20);
        thread.interrupt();

        thread.join();
        System.out.println("MAIN END");
    }
}

class ITExample extends Thread {
    double sqrt = 0;


    @SneakyThrows
    @Override
    public void run() {
        try {
            for (int i = 1; i < 1000000; i++) {

//                Thread.sleep(32);

                if (Thread.interrupted()) {
                    System.out.println("THREAD will be interrupted");
                    return;
                }
                sqrt = Math.sqrt(i);


                Thread.sleep(222);

            }
            System.out.println("SQRT: " + sqrt);
        } catch (InterruptedException e) {
            System.out.println("THREAD was interrupted while sleeping");

        }
    }
}