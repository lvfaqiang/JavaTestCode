package com.lvfq.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * UseCondition
 *
 * @author lvfq
 * @date 2017/5/3 下午2:00
 * @mainFunction :
 */
public class UseCondition {

    /**
     * ReentrantLock 中的 Condition 就像 synchronized  中的 Object lock 一样
     * 示例可见 com.lvfq.thread_wait_notify.ListAdd2
     */
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void method1() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 method 1 ...");
            Thread.sleep(2000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " method 1 释放锁...");

            condition.await(); //  synchronized 中 Object .await()

            System.out.println("当前线程 " + Thread.currentThread().getName() + " method 1 继续执行...");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void method2() {
        try {
            lock.lock();

            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 method 2 ...");
            Thread.sleep(3000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 发出唤醒...");

            condition.signal(); //  synchronized 中 Object .notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        UseCondition useCondition = new UseCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                useCondition.method1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                useCondition.method2();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
