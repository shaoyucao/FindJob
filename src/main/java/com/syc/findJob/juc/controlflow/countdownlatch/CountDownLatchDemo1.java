package com.syc.findJob.juc.controlflow.countdownlatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟5名检察员都检查完毕了，才能开始工作
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("检察员开始检查工作...");
        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    System.out.println("检察员" + no + "开始检查工作...");
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("检察员" + no + "检查完毕");
                    countDownLatch.countDown();
                }
            };
            executorService.execute(runnable);
        }
        countDownLatch.await();
        System.out.println("检察员检查工作完毕");
        executorService.shutdown();

    }
}




