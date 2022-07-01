package com.syc.findJob.juc.controlflow.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    void method1(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "条件不满足，陷入沉睡");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "条件满足，继续工作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void method2() {
        lock.lock();
        try {
            Thread.sleep(1000);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        System.out.println(Thread.currentThread().getName() + "唤醒其他线程");
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                conditionDemo.method2();
            }
        }).start();
        conditionDemo.method1();
    }

}
