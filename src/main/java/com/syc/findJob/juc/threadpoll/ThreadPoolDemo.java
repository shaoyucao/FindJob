package com.syc.findJob.juc.threadpoll;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public void testThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //使用线程池执行任务
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(5);
        threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("被中断了");
                }
                System.out.println(1);
            }
        }, 0, TimeUnit.SECONDS);
        Thread.sleep(2000);
        threadPool.shutdownNow();

    }
}
