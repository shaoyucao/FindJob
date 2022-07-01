package com.syc.findJob.juc.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    static final AtomicInteger atomicInteger = new AtomicInteger(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        MyTask myTask = new MyTask(atomicInteger);
        for(int i = 0; i < 100; i++) {
            executorService.submit(myTask);
        }

        Thread.sleep(1500);
        System.out.println("res: " + atomicInteger.get());
        executorService.shutdown();


    }

    static class MyTask implements Callable<AtomicInteger> {

        AtomicInteger atomicInteger;

        public MyTask(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public AtomicInteger call() throws Exception {
                Thread.sleep(500);
                atomicInteger.getAndIncrement();
            return atomicInteger;
        }
    }
}
