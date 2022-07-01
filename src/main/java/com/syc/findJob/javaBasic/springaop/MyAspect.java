package com.syc.findJob.javaBasic.springaop;

public class MyAspect {

    public void before() {
        System.out.println("check stock...");

    }

    public void after() {
        System.out.println("order created...");
    }

}
