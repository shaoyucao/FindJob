package com.syc.findJob.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {

    private AtomicInteger i = new AtomicInteger(0);

    public void increment() {
        i.incrementAndGet();
    }

    public static void main(String[] args) {

        CAS cas = new CAS();
        cas.increment();
    }
}
