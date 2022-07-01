package com.syc.findJob.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程: " + Thread.currentThread().getName() + "开始准备...");
                    Thread.sleep(3000);
                    System.out.println("线程: " + Thread.currentThread().getName() + "开始行动");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyTask());
        Thread t3 = new Thread(futureTask);

        Thread t4 = new Thread(() -> {
            System.out.println("线程: " + Thread.currentThread().getName() + "行动完毕");
        });
        t4.start();

        t1.start();
        t2.start();
        t3.start();

        System.out.println("准备行动");

        int res = 0;
        try{
            res = futureTask.get();
        }catch (ExecutionException | InterruptedException e) {
            System.out.println("等待时退出");
        }
        System.out.println("线程: " + Thread.currentThread().getName() + "结果: " + res);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程: " + Thread.currentThread().getName() + "行动完毕");
        }
    }

    static class MyTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("线程: " + Thread.currentThread().getName() + "开始准备...");
            Thread.sleep(3000);
            System.out.println("线程: " + Thread.currentThread().getName() + "开始行动");
            return 520;
        }
    }
}
