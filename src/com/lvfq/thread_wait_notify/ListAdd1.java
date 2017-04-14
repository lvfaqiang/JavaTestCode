package com.lvfq.thread_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * ListAdd1
 *
 * @author lvfq
 * @date 2017/4/14 上午11:00
 * @mainFunction :
 */
public class ListAdd1 {

    private static volatile List<String> list = new ArrayList<>();

    public void add() {
        list.add("lvfaqiang");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] arg0) {
        ListAdd1 listAdd1 = new ListAdd1();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        listAdd1.add();

                        Thread.sleep(500);

                        System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加了一个元素...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (listAdd1.size() == 5) {
                        System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止");
                        throw new RuntimeException();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();

    }
}
