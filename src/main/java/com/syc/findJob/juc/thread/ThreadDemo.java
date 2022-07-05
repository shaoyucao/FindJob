package com.syc.findJob.juc.thread;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException{

        ThreadDemo demo = new ThreadDemo();
        demo.threadCreateMethod1();
        demo.threadCreateMethod2();
        demo.threadCreateMethod3();
        demo.threadCreateMethod4();
        demo.threadCreateMethod5();

    }

    public void threadCreateMethod1() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public void threadCreateMethod2() {
        Thread thread = new Thread(new RunnableTask());
        thread.start();
    }

    public void threadCreateMethod3() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableTask());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("当前线程" + thread.getName() + "的返回结果是：" + futureTask.get());
    }

    public void threadCreateMethod4() {
        Thread thread = new Thread(()->{
            System.out.println("方法4， 线程: " + Thread.currentThread().getName() + "创建完毕！");
        });
        thread.start();
    }

    public void threadCreateMethod5() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new ThreadPoolRunnableTask());
        executorService.shutdown();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("方法1， 线程: " + Thread.currentThread().getName() + "创建完毕！");
        }
    }

    class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("方法2， 线程：" + Thread.currentThread().getName() + "创建完毕！");
        }
    }

    class ThreadPoolRunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("方法5， 线程：" + Thread.currentThread().getName() + "创建完毕！");
        }
    }

    class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("方法3， 线程：" + Thread.currentThread().getName() + "创建完毕！");
            return 2;
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
