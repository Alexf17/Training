package org.example._2024_02_17;

public class Mt5 extends Thread{
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("counter: "+counter);

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running");
        Mt5 mt = new Mt5();
        mt.start();
       Thread.sleep(1000);
        System.out.println("Wake Up");
        mt.b = false;
        mt.join();

        System.out.println("End");
    }
}
