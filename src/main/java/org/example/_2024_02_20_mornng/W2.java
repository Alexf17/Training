package org.example._2024_02_20_mornng;

public class W2 {
    public static void main(String[] args) {
        Market2 market = new Market2();
        Producer2 producer = new Producer2(market);
        Consumer2 consumer = new Consumer2(market);
        Seller2 seller = new Seller2(market);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(seller);

        t1.start();
        t2.start();
        t3.start();

    }
}
class Market2{
    private int item = 0;
    private int itemToSell=0;
    public synchronized void sellItem(){
        while (itemToSell<1 && item<1){
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
        itemToSell--;
        System.out.println("factory sell "+itemToSell);
        notify();
    }
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
        System.out.println("factory get " +item);
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
        itemToSell++;
        System.out.println("factory put  "+item);
        notify();
    }
}
class Producer2 implements Runnable{
    Market2 market;

    public Producer2(Market2 market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putItem();
        }

    }
}
class Consumer2 implements Runnable{
    Market2 market;

    public Consumer2(Market2 market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getItem();
        }

    }
}
class Seller2 implements Runnable{
    Market2 market;

    public Seller2(Market2 market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.sellItem();
        }

    }
}
