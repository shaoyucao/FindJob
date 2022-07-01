package com.syc.findJob.juc.controlflow.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("大伙到场，一起发车！");
            }
        });
        for(int i = 0; i < 10; i++){
            new Task(i, cyclicBarrier).start();
        }
    }

    static class Task extends Thread {
        private final int i;
        private final CyclicBarrier cyclicBarrier;
        Task(int i, CyclicBarrier cyclicBarrier) {
            this.i  = i;
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程" + i + "准备前往出发地");
            try {
                Thread.sleep((long)(Math.random()*5000));
                System.out.println("线程" + i + "到达出发地，等待其他人到达");
                cyclicBarrier.await();
                System.out.println("线程" + i + "出发");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
