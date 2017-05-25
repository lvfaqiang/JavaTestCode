package com.lvfq.reflect;

/**
 * Person
 *
 * @author lvfq
 * @date 2017/5/25 下午2:58
 * @mainFunction :
 */
public class Person {
    private String name;
    private int age;

    public Person() {
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

    @Override
    public String toString() {
        return "Name: " + getName() + " , age: " + getAge();
    }
}
