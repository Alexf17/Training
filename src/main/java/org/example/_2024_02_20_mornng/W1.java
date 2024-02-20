package org.example._2024_02_20_mornng;

public class W1 {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

    }
}
class Market{
    private int item = 0;
    public synchronized void getItem(){
        while (item<1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        item--;
        System.out.println("factory sell");
        System.out.println("item "+item);
        notify();
    }
    public synchronized void putItem(){
        while (item>=6){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        item++;
        System.out.println("factory put");
        System.out.println("item "+item);
        notify();
    }
}
class Producer implements Runnable{
Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putItem();
        }

    }
}
class Consumer implements Runnable{
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            market.getItem();
        }

    }
}