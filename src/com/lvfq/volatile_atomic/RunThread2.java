package com.lvfq.volatile_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * RunThread1
 *
 * @author lvfq
 * @date 2017/4/14 上午9:27
 * @mainFunction :
 */
public class RunThread2 extends Thread {

    private static AtomicInteger count = new AtomicInteger();

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
//            count.getAndIncrement();
//            count.addAndGet(2);
//            count.getAndAdd(2);
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] arg0) {
        RunThread2[] ts = new RunThread2[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new RunThread2();
        }
        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
    }
}
