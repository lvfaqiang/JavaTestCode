package com.lvfq.volatile_atomic;

/**
 * RunThread1
 *
 * @author lvfq
 * @date 2017/4/14 上午9:27
 * @mainFunction :
 */
public class RunThread1 extends Thread {

    private static volatile int count;

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] arg0) {
        RunThread1[] ts = new RunThread1[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new RunThread1();
        }

        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
    }
}
