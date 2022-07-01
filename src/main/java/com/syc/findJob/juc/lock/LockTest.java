package com.syc.findJob.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("当前线程" + Thread.currentThread().getId());
                }finally {
                    lock.unlock();
                }

            }
        });
        thread.start();
    }
}
