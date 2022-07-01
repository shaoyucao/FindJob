package com.syc.findJob.javaBasic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generics {

    /**
     * Java中的 泛型 是参数化类型，
     * 1. 提供了编译时类型安全监测机制
     * 2. 该泛型是伪泛型，因为在运行期间，所有泛型信息都会被擦除
     */
    public void testGenerics() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Class<? extends List> clazz = list.getClass();
        //通过clazz可以获取该对象拥有的所有方法；第一个为方法名，第二个为方法参数
        Method add = clazz.getDeclaredMethod("add", Object.class);
        /**
         * 运行期间可以将“a"插入到整型集合中
         */
        add.invoke(list, "a");
        System.out.println(list);
    }

    /**
     * 泛型方法1
     * @param array
     * @param <T>
     */
    public <T> void printArray(T[] array) {
        for(T t : array) {
            System.out.println("t:" + t);
        }
    }

    /**
     * 泛型方法2
     * @param t
     * @param <T>
     * @return
     */
    public <T> T getT(T t) {
        System.out.println(t.getClass());
        return t;
    }



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //test1
//        new Generics().testGenerics();

        //test2
        Integer t = new GenericsClass<Integer>(2).getT();
        System.out.println(t);
    }
}

/**
 * 使用方法1：泛型类
 * @param <T>
 */
class GenericsClass<T> {
    private T t;

    public GenericsClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}

