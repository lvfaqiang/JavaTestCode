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
public class ListAdd2 {

    private static volatile List<String> list = new ArrayList<>();

    public void add() {
        list.add("lvfaqiang");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] arg0) {

        final ListAdd2 listAdd2 = new ListAdd2();

        Object lock = new Object();// wait  notify 要配合 synchronized 使用

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run ");
                try {
                    synchronized (lock) {
                        for (int i = 0; i < 10; i++) {
                            listAdd2.add();
                            System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加了一个元素...");

                            Thread.sleep(500);
                            if (listAdd2.size() == 5) {
                                System.out.println("已经发出通知");
                                lock.notify(); // notify 不释放锁
                            }

                        }
                        System.out.println("当前线程：" + Thread.currentThread().getName() + " , list size : " + listAdd2.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 run ");
                synchronized (lock) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + " , 已进来 , list size : " + listAdd2.size());
                    if (listAdd2.size() != 5) {
                        try {
                            lock.wait();    // wait 方法释放锁  当前线程阻塞在这里，等待 notify 唤醒之后继续往下执行。
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " 线程停止");
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " , list size : " + listAdd2.size());
                    throw new RuntimeException();
                }
            }
        }, "t2");

        t2.start();
        t1.start();

    }
}
