package com.learn.java.base.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RandPrint {
    private static volatile Boolean stoped = false;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA =new Semaphore(1);
        Semaphore semaphoreB =new Semaphore(1);
        Semaphore semaphoreC =new Semaphore(1);
        Semaphore semaphoreD =new Semaphore(1);
        Printer printerA = new Printer("A",semaphoreA,semaphoreB);

        Printer printerB = new Printer("B",semaphoreB,semaphoreC);

        Printer printerC = new Printer("C",semaphoreC,semaphoreD);

        Printer printerD = new Printer("D",semaphoreD,semaphoreA);
        semaphoreA.acquire();
        semaphoreB.acquire();
        semaphoreC.acquire();
        semaphoreD.acquire();
        ExecutorService threadPool= Executors.newFixedThreadPool(4);
        threadPool.submit(printerA);
        threadPool.submit(printerB);
        threadPool.submit(printerC);
        threadPool.submit(printerD);
        semaphoreA.release();
        TimeUnit.SECONDS.sleep(1);
        stoped=true;
        threadPool.shutdown();
    }

    static class Printer implements Runnable {
        private final String myFlag;
        private final Semaphore semaphore;
        private final Semaphore next;

        public Printer(String myFlag, Semaphore semaphore, Semaphore next) {
            this.myFlag = myFlag;
            this.semaphore = semaphore;
            this.next = next;
        }

        @Override
        public void run() {
            while (!stoped) {
                try {
                    semaphore.acquire();
                    System.out.println("print flag:" + myFlag);
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
