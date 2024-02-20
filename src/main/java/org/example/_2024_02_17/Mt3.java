package org.example._2024_02_17;

public class Mt3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Mt3");
       Thread t1 =  new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(i + " T1i "+ Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(i + " T2i "+ Thread.currentThread().getName());
            }
        });
        t2.start();
        t1.start();

        t1.join();
        t2.join();
        System.out.println("Finished");
    }
}
