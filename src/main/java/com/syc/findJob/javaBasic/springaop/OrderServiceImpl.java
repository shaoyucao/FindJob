package com.syc.findJob.javaBasic.springaop;

public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder() {
        System.out.println("创建订单");
    }

}
