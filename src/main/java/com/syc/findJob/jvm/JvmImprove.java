package com.syc.findJob.jvm;

public class JvmImprove {
    public static void main(String[] args) {
        //下面这些单位是字节B，要获取到GB，需要除以三次1024
        System.out.println("JVM Xmx: " + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
        System.out.println("JVM totalMemory: " + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
        System.out.println("JVM freeMemory: " + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");

//        System.out.println("------------");
//
//        byte[] b = new byte[1 * 1024 * 1024];
//        System.out.println("JVM Xmx: " + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
//        System.out.println("JVM totalMemory: " + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
//        System.out.println("JVM freeMemory: " + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
//
        System.out.println("------------");

        byte[] c = new byte[10 * 1024 * 1024];
        System.out.println("JVM Xmx: " + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
        System.out.println("JVM totalMemory: " + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
        System.out.println("JVM freeMemory: " + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");

        System.out.println("------------");
        System.out.println("清理一次内存空间");
        System.gc();

        System.out.println("JVM Xmx: " + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
        System.out.println("JVM totalMemory: " + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
        System.out.println("JVM freeMemory: " + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");

    }
}
