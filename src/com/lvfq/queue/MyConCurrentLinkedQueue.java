package com.lvfq.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * MyConCurrentLinkedQueue
 *
 * @author lvfq
 * @date 2017/4/16 下午3:14
 * @mainFunction :
 */
public class MyConCurrentLinkedQueue {


    public static void main(String[] args) throws InterruptedException {

        /**
         * 高性能 无阻塞 无界队列，ConcurrentLinkedQueue
         * 在 ConcurrentLinkedQueue 中 ， offer 和 add 是没有区别的， add 方法内部也是调用的 offer .
         */
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("d");
        q.offer("f");
        /**
         * poll() peek() 都是获取 头元素，两者的区别是，前者会删除元素，后者不会。
         */
//        System.out.println(q.poll()); // result : a
//        System.out.println(q.size()); // result : 4
//
//        System.out.println(q.peek()); // result : b
//        System.out.println(q.size()); // result : 4


        /**
         *  在阻塞队列中，如果当前队列未满的情况下， add 和 offer 方法是一样的，
         *  如果当前队列满了，那么调用 add 方法，会抛出 IllegalStateException queue full 异常信息
         */

        // 有界队列
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(4);
        array.add("a");
        array.offer("b");
        array.offer("c");
        array.offer("d");
        array.offer("e");
//        array.put("f");//  put 方法如果当前 队列满了之后，那么该线程就阻塞在这里，等待队列消费之后，再进行添加。
//        System.out.println(array.toString());

        // 无界队列  传参，表示指定长度， 不传，表示 无界。
        LinkedBlockingQueue<String> linkedArray = new LinkedBlockingQueue<>(5);
        linkedArray.add("a");
        linkedArray.offer("b");
        linkedArray.put("c");
        linkedArray.offer("d");
        linkedArray.offer("e");
        linkedArray.offer("f");

//        System.out.println(linkedArray.toString());
        List<String> list = new ArrayList<>();
        linkedArray.drainTo(list, 3); // drainTo 方法获取队列中的 前几条数据，填充到指定的集合（Collection 的子类 ）中。
//        System.out.println(list.toString());


        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        // 要先有 调用 take 方法，再调用 add 方法， 不走队列内部，直接传递个 take 方法
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronousQueue.add("synchronousQueue.add");
            }
        }, "t2");
        t2.start();

    }
}
