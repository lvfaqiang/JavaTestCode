package com.lvfq.concurrent.locks;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * UseReentrantLock
 *
 * @author lvfq
 * @date 2017/5/3 下午1:40
 * @mainFunction :
 */
public class UseReentrantLock {

    /**
     * ReentrantLock 必须在最后进行 unlock 方法调用。
     * JDK 1.8 之前，sync 比 lock 性能差一点， 1.8之后sync 优化了一下，差不多了 ，但是 lock 比 sync 更灵活
     */
    private ReentrantLock lock = new ReentrantLock();

    private void method1() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 method 1 ...");
            Thread.sleep(2000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 退出 method 1 ...");
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
            Thread.sleep(2000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 退出 method 2 ...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        UseReentrantLock useReentrantLock = new UseReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantLock.method1();
                useReentrantLock.method2();
            }
        }, "t1");

        thread.start();
    }

}
