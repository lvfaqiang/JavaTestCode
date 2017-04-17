package com.lvfq.queue;

/**
 * PriorityBlockingTask
 *
 * @author lvfq
 * @date 2017/4/16 下午10:42
 * @mainFunction :
 */
public class PriorityBlockingTask implements Comparable<PriorityBlockingTask> {

    private int id;
    private String name;

    public PriorityBlockingTask(int id, String name) {
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

    @Override
    public int compareTo(PriorityBlockingTask o) {
        if (this.getId() > o.getId()) {
            return -1;
        } else if (this.getId() < o.getId()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "id :" + this.getId() + " , name :" + this.getName();
    }
}
