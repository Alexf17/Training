package org.example._2024_01_11_morning;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueEx {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(()->{
            String[]words = {"ar", "br", "cr", "dr", "er"};

            for(int i =1; i<words.length && !Thread.interrupted(); i++){
                try{
                    Thread.sleep(1200);
                    queue.put(words[i]);
                    System.out.println("Producer produce : "+ words[i]);
                    System.out.println("Queue size : "+ queue.size());
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                i++;
            }
        });
        Thread consumer = new Thread(()->{
            StringBuilder sb = new StringBuilder();
            while (!Thread.interrupted()){
                try{
                    sb.setLength(0);
                    Thread.sleep(2000);
                    sb.append(queue.take());
                    System.out.println("Concumer concum : "+ sb.reverse());
                    System.out.println("Queue size : "+ queue.size());
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }



        });

        producer.start();
        consumer.start();
    }


}
