package org.example._2024_02_17;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private static long sum = 0;


    public static void main(String[] args) throws InterruptedException {


        List<Integer> list = new ArrayList<Integer>(100000);
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < list.size() / 4; i++) {
                sum += list.get(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = list.size() / 4; i < list.size() / 2; i++) {
                sum += list.get(i);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = list.size() / 2; i < list.size() * 3 / 4; i++) {
                sum += list.get(i);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = list.size() * 3 / 4; i < list.size(); i++) {
                sum += list.get(i);
            }
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

        System.out.println(sum);
    }
}
