package com.lvfq.reflect;

/**
 * Children
 *
 * @author lvfq
 * @date 2017/5/25 上午9:17
 * @mainFunction :
 */
public class Children extends Parent {

    private String hobby;

    public Children() {
    }

    public Children(String name, int age) {
        super(name, age);
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
