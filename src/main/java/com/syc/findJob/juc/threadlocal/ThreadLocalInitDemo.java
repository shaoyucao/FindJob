package com.syc.findJob.juc.threadlocal;

import java.text.SimpleDateFormat;

public class ThreadLocalInitDemo {
    public static void main(String[] args) {

        //method 1, demo1
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 2;
            }
        };
        System.out.println(threadLocal.get());

        //method 1, demo 2
        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal =
                new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    }
                };

        //method 2
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("demo2");
        System.out.println(threadLocal2.get());
    }
}
