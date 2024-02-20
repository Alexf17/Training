package org.example._2024_02_17;

public class Mt4 {
    public static void main(String[] args) throws InterruptedException {
        Thread TH = new Thread();
        System.out.println(TH.getState());
        TH.start();
        TH.setName("test");
        TH.setPriority(10);
        Thread.sleep(1000);
        System.out.println(TH.getState());
        System.out.println(TH.getName());
    }
}
