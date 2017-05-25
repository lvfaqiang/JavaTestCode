package com.lvfq.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ReflectMain2
 *
 * @author lvfq
 * @date 2017/5/25 上午10:09
 * @mainFunction :
 */
public class ReflectMain2 {


    public static void main(String[] args) {
        Class<?> c = null;
        Parent parent = null;

        try {
            c = Class.forName("com.lvfq.reflect.Children");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Constructor<?>[] constructor = c.getConstructors();

        /**
         * 打印所有的构造方法
         */
        for (int i = 0; i < constructor.length; i++) {
            System.out.println("构造方法：" + constructor[i]);
        }

        /**
         * 打印所有实现了的接口。
         */
        for (int i = 0; i < c.getInterfaces().length; i++) {
            System.out.println("实现的接口：" + c.getInterfaces()[i]);
        }

        System.out.println("继承的父类： " + c.getSuperclass());

        /**
         * 打印所有public 修饰的参数(包括父类)
         */
        for (int i = 0; i < c.getFields().length; i++) {
            System.out.println(" field : " + c.getFields()[i] + "\n");
        }


        /**
         * 打印当前类中所有参数
         */
        for (int i = 0; i < c.getDeclaredFields().length; i++) {
            System.out.println("DeclaredFields : " + c.getDeclaredFields()[i]);
        }

        /**
         * 获取当前类中的所有方法（仅限此类中的方法）。
         */
//        for (int i = 0; i < c.getDeclaredMethods().length; i++) {
//            System.out.println("DeclaredMethods : " + c.getDeclaredMethods()[i]);
//        }

        /**
         * 获取类里的所有方法（包括父类中的方法）
         */
//        for (int i = 0; i < c.getMethods().length; i++) {
//            System.out.println("Method : " + c.getMethods()[i]);
//        }

        try {
            parent = (Parent) constructor[0].newInstance("发强", 18);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(parent.toString());


    }
}
