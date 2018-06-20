package com.lvfq.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectMain
 *
 * @author lvfq
 * @date 2018/6/20 下午5:42
 * @mainFunction :
 * <p>
 * 反射
 */
public class ReflectMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        User user = new User("BigBrother", 18);
        Class clazz = user.getClass();


//        拿到成员变量
        // getField 只能拿到 public 修饰的成员属性
        Field fieldAge = clazz.getField("age");

        //  getDeclaredField 可以取出 private 修饰的属性
        Field fieldName = clazz.getDeclaredField("name");
        fieldName.setAccessible(true); // 允许对当前属性进行操作（暴力反射）， 操作私有属性，此方法必须要有。

        int age = fieldAge.getInt(user);
        String name = (String) fieldName.get(user);
        System.out.println("----------------  输出原始值  --------------");

        System.out.println("age: " + age + " , name :" + name);


        System.out.println("----------------  修改后的值  --------------");

        fieldAge.setInt(user, 20);
        fieldName.set(user, "发强");
        System.out.println("age: " + user.getAge() + " , name :" + user.getName());


        System.out.println("----------------  调用方法  --------------");

        Method method = clazz.getMethod("modifyName", String.class);
        method.invoke(user, "大强哥");
    }


    public static class User {
        private String name;
        public int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void modifyName(String name) {
            System.out.println("以后修改名字为： " + name);
        }

    }
}
