package com.lvfq.queue;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MyQueue
 *
 * @author lvfq
 * @date 2017/4/14 下午3:51
 * @mainFunction : 自定义线程队列
 */
public class MyQueue {

    //存放当前队列中的数据
    private LinkedList<Object> list = new LinkedList<>();

    //记录当前队列中的数量 是线程安全的。
    private AtomicInteger count = new AtomicInteger(0);

    // 当前队列最大值
    private final int maxSize;
    //当前队列最小值
    private final int minSize = 0;

    //用于设置线程锁
    private Object lock = new Object();

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    private int getSize() {
        return count.get();
    }

    /**
     * 往队列添加元素
     *
     * @param object
     */
    public void put(Object object) {
        synchronized (lock) {
            if (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 添加元素
            list.add(object);
            //数量 ++
            count.incrementAndGet();
            // 唤醒(当队列为空的时候，有take 方法在等待，唤醒 take 方法)
            lock.notify();
            System.out.println("添加元素为： " + object);
        }
    }

    /**
     * 移除当前队列中的第一个元素
     *
     * @return
     */
    public Object take() {
        Object obj = null;
        synchronized (lock) {
            if (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 移除队列中的第一个对象
            obj = list.removeFirst();
            // 数量 --
            count.decrementAndGet();
            // 当有添加线程在等待时，唤醒 put 方法
            lock.notify();
            System.out.println("移除元素： " + obj);
        }
        return obj;
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");
        queue.put("e");

        System.out.println("当前队列数量：" + queue.getSize());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("f");
                queue.put("g");
//                com.lvfq.queue.put("h");
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.take();
                queue.take();
                queue.take();
            }
        }, "t2");

        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
