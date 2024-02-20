package org.example._2024_02_20_mornng;

public class DL {
    public static final DL1 dl1 = new DL1();
    public static final DL2 dl2 = new DL2();

    public static void main(String[] args) {
        Thread tr1 = new Thread(dl1);
        Thread tr2 = new Thread(dl2);

        tr1.start();
        tr2.start();
    }
}

class DL1 implements Runnable {
    @Override
    public void run() {
        synchronized (DL.dl1) {
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
            }
            synchronized (DL.dl2) {
                System.out.println("dl2 enter to dl1");
            }
        }



    }
}

class DL2 implements Runnable {
    @Override
    public void run() {
        synchronized (DL.dl2) {
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
            }
            synchronized (DL.dl1) {
                System.out.println("dl1 enter to dl2");
            }
        }


    }
}

