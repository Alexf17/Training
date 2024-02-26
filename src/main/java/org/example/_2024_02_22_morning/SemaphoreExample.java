package org.example._2024_02_22_morning;

import com.github.javafaker.Faker;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final Faker FAKER = new Faker();
    private static Semaphore semaphore = new Semaphore(4);
    public static void main(String[] args) {
        String p1 = FAKER.funnyName().name();
        String p2 = FAKER.funnyName().name();
        String p3 = FAKER.funnyName().name();
        String p4 = FAKER.funnyName().name();
        String p5 = FAKER.funnyName().name();
        String p6 = FAKER.funnyName().name();
        String p7 = FAKER.funnyName().name();
        String p8 = FAKER.funnyName().name();
        String p9 = FAKER.funnyName().name();

        Pers pers1 = new Pers(p1,semaphore);
        Pers pers2 = new Pers(p2,semaphore);
        Pers pers3 = new Pers(p3,semaphore);
        Pers pers4 = new Pers(p4,semaphore);
        Pers pers5 = new Pers(p5,semaphore);
        Pers pers6 = new Pers(p6,semaphore);
        Pers pers7 = new Pers(p7,semaphore);
        Pers pers8 = new Pers(p8,semaphore);
        Pers pers9 = new Pers(p9,semaphore);

        pers1.setName(p1);
        pers2.setName(p2);
        pers3.setName(p3);
        pers4.setName(p4);
        pers5.setName(p5);
        pers6.setName(p6);
        pers7.setName(p7);
        pers8.setName(p8);
        pers9.setName(p9);

        pers1.start();
        pers2.start();
        pers3.start();
        pers4.start();
        pers5.start();
        pers6.start();
        pers7.start();
        pers8.start();
        pers9.start();

    }
}

class Pers extends Thread{
    String name;
    private Semaphore semaphore;

    public Pers(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("User: " + name + " is waiting for...... ... . . .     .");

            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " : IN****");
            Thread.sleep(5020);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " : OUT****");
            try {
                Thread.sleep(502);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphore.release();

        }
    }
}

class Box {

}