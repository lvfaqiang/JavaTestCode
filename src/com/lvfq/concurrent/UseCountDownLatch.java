package com.lvfq.concurrent;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * UseCountDownLatch
 *
 * @author lvfq
 * @date 2017/5/2 下午4:11
 * @mainFunction :
 *
 */
public class UseCountDownLatch {

    public static void main(String[] args) {

        /**
         * 相类似的 有  CyclicBarrier
         * CountDownLatch 是其他线程控制某一个线程， CyclicBarrier 是控制多个线程同步。
         */
        CountDownLatch countDownLatch = new CountDownLatch(1); // 参数表示 线程执行 await()方法后，需要调用几次 countDown()方法才能唤醒线程继续。

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程 t1 , 通知t1 线程继续。。。。");
                    countDownLatch.await();
                    System.out.println("线程 t1 继续执行。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程    t2    进行初始化操作");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("线程 t2 初始化完成。");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程  t3 开始初始化操作");
                    Thread.sleep(5000);
                    System.out.println("线程 t3 初始化完成。");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
