package com.syc.findJob.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generical {
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

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new Generical().testGenerics();

    }
}
