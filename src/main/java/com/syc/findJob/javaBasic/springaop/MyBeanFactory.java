package com.syc.findJob.javaBasic.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static OrderService orderService = new OrderServiceImpl();

    public static MyAspect myAspect =  new MyAspect();

    public static OrderService createBean() {

        return (OrderService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                orderService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.before();
                        Object obj = method.invoke(orderService, args);
                        myAspect.after();
                        return obj;
                    }
                }
        );
    }



}
