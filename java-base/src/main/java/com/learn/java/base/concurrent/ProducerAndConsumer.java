package com.learn.java.base.concurrent;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {
    private static volatile Boolean stoped=false;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        LinkedList<Double> store = new LinkedList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition full = reentrantLock.newCondition();
        Condition empty = reentrantLock.newCondition();
        Producer producer = new Producer(store, full,empty, reentrantLock);
        Consumer consumer = new Consumer(store, full,empty, reentrantLock);

        service.submit(producer);
        service.submit(consumer);
        TimeUnit.SECONDS.sleep(1);

        TimeUnit.SECONDS.sleep(10);
        service.shutdown();
    }

    static class Producer implements Runnable {
        private final LinkedList<Double> store;
        private final Condition full;
        private final Condition empty;
        private final ReentrantLock lock;

        public Producer(LinkedList<Double> store, Condition full, Condition empty, ReentrantLock lock) {
            this.store = store;
            this.full = full;
            this.empty = empty;
            this.lock = lock;
        }

        @Override
        public void run() {
           while (!stoped){
               lock.lock();
               try {
                   if (store.size()==10){
                       System.out.println("store full");
                       full.await();
                   }
                   store.offer(Math.random());
                   System.out.println("produce ....");
                   empty.signal();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    static class Consumer implements Runnable {
        private final LinkedList<Double> store;
        private final Condition full;
        private final Condition empty;
        private final ReentrantLock lock;

        public Consumer(LinkedList<Double> store, Condition full, Condition empty, ReentrantLock lock) {
            this.store = store;
            this.full = full;
            this.empty = empty;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (!stoped){
                lock.lock();
                try {
                    if (store.size()==0){
                        System.out.println("store empty");
                        empty.await();
                    }
                    System.out.println("consume...");
                    System.out.println(store.pop());
                    if (store.size()<10){
                        System.out.println("store not full");
                        full.signal();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
