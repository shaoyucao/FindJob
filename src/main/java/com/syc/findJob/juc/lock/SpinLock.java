package com.syc.findJob.juc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自己动手实现一个自旋锁
 */
public class SpinLock {
    private final AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        while(!sign.compareAndSet(null, thread)) {
            System.out.println("当前线程"+thread.getName()+"获取自选锁失败，再次尝试...");
        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        sign.compareAndSet(thread, null);
        System.out.println("当前线程" + Thread.currentThread().getName() + "释放了自旋锁");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                System.out.println("当前线程" + Thread.currentThread().getName() + "获取到了自旋锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                spinLock.unLock();
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            spinLock.lock();
            System.out.println("当前线程" + Thread.currentThread().getName() + "获取到了自旋锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spinLock.unLock();
        });
        t2.start();
    }
}
