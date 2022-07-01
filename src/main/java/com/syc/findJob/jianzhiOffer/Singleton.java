package com.syc.findJob.jianzhiOffer;

public class Singleton {

    /**
     * 适用于单线程的单例模式
     */
    private Singleton() {

    }

    //必须声明为静态成员变量(可以不初始化，默认值为null)
    private static Singleton singleton;

    //公有的静态方法获取实例对象
    public static Singleton getInstance() {
        if (null == singleton) {
            singleton = new Singleton();

        }
        return singleton;
    }
}

/**
 * 线程安全，效率低
 */
class Singelton2 {

    private Singelton2() {

    }

    private static Singelton2 singelton2 = null;

    public static synchronized Singelton2 getInstance() {
        if(null == singelton2) {
            singelton2 = new Singelton2();
        }
        return singelton2;
    }

}

/**
 * double check
 */
class Singleton3 {

    private Singleton3() {

    }

    //volatile保证原子性，并禁止指令重排序
    private volatile static Singleton3 singleton3;

    public static Singleton3 getInstance() {
        if(null == singleton3) {
            synchronized (Singleton3.class) {
                if(null == singleton3) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }


}

/**
 * 静态内部类方式
 */
class Singleton4 {

    private Singleton4() {

    }

    //静态内部类在外部类装载的时候并不会立即实例化，而是在被调用的时候实例化（即在调用getInstance的时候实例化）
    private static class InnerSingle {
        public static Singleton4 singleton4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return InnerSingle.singleton4;
    }

}
