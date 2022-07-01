package com.syc.findJob.juc.controlflow.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟5名运动员都准备就绪，等待100米开始跑步
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*2000));
                        System.out.println("运动员" + no + "准备完毕！");
                        countDownLatch.await();
                        System.out.println("运动员" + no + "开始跑步！" );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }

        System.out.println("裁判员、运动员开始准备...");
        Thread.sleep(3000);
        System.out.println("枪响！");
        countDownLatch.countDown();
        executorService.shutdown();

    }
}
