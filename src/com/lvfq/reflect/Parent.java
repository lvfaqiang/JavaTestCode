package com.lvfq.reflect;

/**
 * Parent
 *
 * @author lvfq
 * @date 2017/5/25 上午9:16
 * @mainFunction :
 */
public class Parent implements ICallBack {

    public static final int CODE = 0;
    public static final String TYPE = "type";

    @Override
    public void setType(String type) {
        System.out.println("Parent getType : " + type);
    }

    private String name;
    public int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public Parent() {
//    }

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

    @Override
    public String toString() {
        return "姓名： " + getName() + " , 年龄：" + getAge();
    }
}
