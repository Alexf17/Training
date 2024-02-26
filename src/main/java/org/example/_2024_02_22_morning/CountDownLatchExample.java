package org.example._2024_02_22_morning;

import com.github.javafaker.Faker;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static final Faker FAKER = new Faker();

    private static void startEngine() {
        try {
            Thread.sleep(600);
            System.out.println("The button was pushed!!");
            Thread.sleep(600);
            System.out.println("The Engine was started");
            System.out.println("*********************************************");
            countDownLatch.countDown();
            System.out.println("CDL: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appSetUp() {
        try {
            Thread.sleep(600);
            System.out.println("Set UP!");
            System.out.println("*********************************************");
            countDownLatch.countDown();
            System.out.println("CDL: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runSystem() {
        try {
            Thread.sleep(600);
            System.out.println("System is ready to run");
            System.out.println("*********************************************");
            countDownLatch.countDown();
            System.out.println("CDL: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new User(FAKER.funnyName().name(), countDownLatch);
        new User(FAKER.funnyName().name(), countDownLatch);
        new User(FAKER.funnyName().name(), countDownLatch);
        new User(FAKER.funnyName().name(), countDownLatch);

        startEngine();
        appSetUp();
        runSystem();
    }
}

class User extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public User(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
//        try {
//            this.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("----USER: " + name + " START TO WORK----");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
