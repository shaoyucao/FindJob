package com.syc.findJob.javaBasic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public void speak() {
        System.out.println("speak");
    }

    public void sleep() {
        System.out.println("sleep");
    }

    private Integer weight;

    private Integer height;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Reflection reflection = new Reflection();
        Class<? extends Reflection> ref = reflection.getClass();
        //例子1：使用反射获取方法
        //获取自定义的方法，getMethods方法可以获取object中的所有方法
        Method[] methods = ref.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println(m.getName());
        }
        //例子2：使用反射获取属性
        Field[] declaredFields = ref.getDeclaredFields();
        for(Field f : declaredFields) {
            System.out.println(f.getName());
        }
        //例子4：使用反射调用方法
        Method speak = ref.getDeclaredMethod("speak");
        speak.invoke(reflection);
        //例子5：使用反射创建对象;性能更低，编译器无法对反射相关的代码做优化
        Reflection reflection1 = (Reflection) Class.forName("com.syc.findJob.javaBasic.Reflection").newInstance();


    }
}
