package com.lvfq.reflect;

import com.lvfq.reflect.Parent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ReflectMain1
 *
 * @author lvfq
 * @date 2017/5/25 上午9:27
 * @mainFunction : 利用 Class 类实例化对象
 */
public class ReflectMain1 {

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName(Parent.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 实例化对象方式 一：
         * 需要有参数的构造方法。 这两种方式不能同时存在有参和无参的构造参数。
         */
        Parent parent = null;
        Constructor<Parent>[] cons = (Constructor<Parent>[]) c.getConstructors();
        try {
            parent = cons[0].newInstance("李四", 12);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /**
         * 实例化对象方式 二：
         */
        // 以下写法需要 parent 对象中存在一个无参数构造方法。
//        try {
//            parent = (Parent) c.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        parent.setAge(10);
//        parent.setName("张三");
        System.out.println(parent.toString());
    }
}
