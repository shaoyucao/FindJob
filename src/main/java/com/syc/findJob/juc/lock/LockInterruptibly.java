package com.syc.findJob.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly implements Runnable{

    private static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");

        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "成功获取锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "等锁期间被中断");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }
    }

    public static void main(String[] args) {
        LockInterruptibly lockInterruptibly = new LockInterruptibly();

        Thread t1 = new Thread(lockInterruptibly);
        Thread t2 = new Thread(lockInterruptibly);

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
