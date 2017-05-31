package com.lvfq.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectMain3
 *
 * @author lvfq
 * @date 2017/5/25 下午12:34
 * @mainFunction : 通过反射调用类中的方法。
 */
public class ReflectMain3 {

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName(Person.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 调用有参方法
         */
        Person person = null;
        try {
            Method method = c.getMethod("setName", String.class);
            person = (Person) c.newInstance(); // 实例化方式，参考 ReflectMain1
            method.invoke(person, "张三");    // 传递参数，与c.getMethod 后面的参数类型相对应
            System.out.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 调用无参方法
        try {
            Method m = c.getMethod("getName");
            System.out.println(m.getGenericReturnType());
            System.out.println(m.invoke(person));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
