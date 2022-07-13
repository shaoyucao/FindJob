package com.syc.findJob.jvm;

import java.util.concurrent.locks.ReentrantLock;

public class JavaMemoryImprove {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(()->{
            lock1.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock2.lock();
        });
        t1.start();

        Thread t2 = new Thread(()->{
            lock2.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock1.lock();

        });
        t2.start();

    }
}
