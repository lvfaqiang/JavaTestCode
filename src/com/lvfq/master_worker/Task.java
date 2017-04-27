package com.lvfq.master_worker;

/**
 * Task
 *
 * @author lvfq
 * @date 2017/4/26 下午3:11
 * @mainFunction :
 */
public class Task {
    private int id;
    private String name;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
