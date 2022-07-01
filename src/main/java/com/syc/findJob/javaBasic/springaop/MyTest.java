package com.syc.findJob.javaBasic.springaop;

public class MyTest {
    public static void main(String[] args) {
        OrderService proxyService = MyBeanFactory.createBean();
        proxyService.createOrder();

    }
}
