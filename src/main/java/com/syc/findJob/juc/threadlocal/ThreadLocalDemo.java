package com.syc.findJob.juc.threadlocal;

import java.text.SimpleDateFormat;

public class ThreadLocalDemo {
    public static void main(String[] args) {

        //method 1
        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal =
                new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    }
                };

        //method 2
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(2);
    }
}
