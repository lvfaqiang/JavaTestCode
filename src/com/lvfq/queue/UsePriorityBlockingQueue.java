package com.lvfq.queue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * UsePriorityBlockingQueue
 *
 * @author lvfq
 * @date 2017/4/16 下午10:40
 * @mainFunction :  PriorityBlockingQueue 测试
 */
public class UsePriorityBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        // 优先级队列  对象必须实现 Comparable 接口。
        PriorityBlockingQueue<PriorityBlockingTask> queue = new PriorityBlockingQueue<>();

        queue.add(new PriorityBlockingTask(1, "task1"));
        queue.add(new PriorityBlockingTask(23, "task4"));
        queue.add(new PriorityBlockingTask(3, "task2"));
        queue.add(new PriorityBlockingTask(6, "task3"));

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.take().getName());
        }

//        for (Iterator iterator = queue.iterator(); iterator.hasNext(); ) {
//            PriorityBlockingTask task = (PriorityBlockingTask) iterator.next();
//            System.out.println(task.getName());
//        }

    }

}
