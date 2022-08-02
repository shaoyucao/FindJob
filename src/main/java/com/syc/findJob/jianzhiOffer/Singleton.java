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
        private static final Singleton4 singleton4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return InnerSingle.singleton4;
    }

}


/////////////// review

/**
 * 单例模式，双重检查
 */
class Singleton5 {

    private static volatile Singleton5 singleton5;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if(singleton5 == null) {
            synchronized (Singleton5.class) {
                if(singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }

}

/**
 * 单例模式，静态内部类
 */
class Singleton6 {
    private Singleton6() {

    }

    private static class SingletonInnerClass {
        private static final Singleton6 singleton6 = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingletonInnerClass.singleton6;
    }
}

/**
 * 单例模式，饿汉式
 */
class Singleton7 {
    private Singleton7() {

    }

    private static Singleton7 singleton7 = new Singleton7();

    public static Singleton7 getInstance() {
        return singleton7;
    }
}

/**
 * 单例模式，懒汉式，线程安全，效率低
 */
class Singleton8 {
    private Singleton8() {

    }

    private static Singleton8 singleton8;

    public static synchronized Singleton8 getInstance() {
        if(null == singleton8)
            singleton8 =  new Singleton8();
        return singleton8;
    }
}
