package com.learn.java.base.concurrent;

import java.util.concurrent.*;

public class RandomPrintWithBatch {
    static volatile boolean stoped=false;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        Printer printerA = new Printer(countDownLatch,cyclicBarrier,"A");
        Printer printerB = new Printer(countDownLatch,cyclicBarrier,"B");
        Printer printerC = new Printer(countDownLatch,cyclicBarrier,"C");
        Printer printerD = new Printer(countDownLatch,cyclicBarrier,"D");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(printerA);
        executorService.submit(printerB);
        executorService.submit(printerC);
        executorService.submit(printerD);
        TimeUnit.SECONDS.sleep(1);
        stoped=true;
        executorService.shutdown();
    }
    static class Printer implements Runnable{
        private  final CountDownLatch startSingel;
        private final CyclicBarrier cyclicBarrier;
        private final String flag;

        public Printer(CountDownLatch startSingel, CyclicBarrier cyclicBarrier, String flag) {
            this.startSingel = startSingel;
            this.cyclicBarrier = cyclicBarrier;
            this.flag = flag;
        }

        @Override
        public void run() {
            startSingel.countDown();
            System.out.println("start...");
            System.out.println("my flag:"+flag);
            while (!stoped){
                try {
                    cyclicBarrier.await();
                    System.out.println("my flag:"+flag);

                } catch (Exception e) {

                }
            }
        }
    }
}
