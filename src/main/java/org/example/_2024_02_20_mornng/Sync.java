package org.example._2024_02_20_mornng;

public class Sync {
    public static void main(String[] args) throws InterruptedException {
        MRI mri = new MRI();

Thread t1 = new Thread(mri);
Thread t2 = new Thread(mri);

t1.start();
t2.start();



        }

}

class Counter{
long count = 0;

}
class MRI implements Runnable {
Counter counter = new Counter();
    public void inc() {
        //-------------   -------------------
        synchronized (this) {
            try {
                Thread.sleep(400);
                counter.count++;
                System.out.println("COUNTER: " + counter.count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {

                inc();

        }
    }
}