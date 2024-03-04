package org.example._2024_02_27_morning;

import java.io.FileWriter;
import java.io.IOException;

public class Dex1 {
    public static void main(String[] args) {
        System.out.println("MAIN START");
        UT1 ut1 = new UT1();
        DT dt = new DT();

        ut1.setName("USER THREAD");
        dt.setName("DAEMON THREAD");

        dt.setDaemon(true);

        ut1.start();
        dt.start();

        System.out.println("MAIN END");
    }
}

class UT1 extends Thread {

    @Override
    public void run() {
        System.out.println("UT1 NAME: " + Thread.currentThread().getName());
        System.out.println("UT1 IS DAEMON: " + isDaemon());

        try(FileWriter writer = new FileWriter("user.txt"))  {
            for (char c = '!'; c < 'z'; c++) {
                Thread.sleep(444);
                writer.write("UT1 --> " + c+ "\n");
                System.out.println("UT1 --> " + c+ "\n");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

class DT extends Thread {

    @Override
    public void run() {
        System.out.println("DT NAME: " + Thread.currentThread().getName());
        System.out.println("DT IS DAEMON: " + isDaemon());

        try(FileWriter writer = new FileWriter("user2.txt")) {
            for (int i = 0; i < 999; i++) {
                Thread.sleep(888);
                writer.write("DT --> " + i);
                writer.flush();
                System.out.println("DT --> " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}