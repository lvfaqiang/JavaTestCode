package com.lvfq.concurrent.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * UseReentrantReadWriteLock
 *
 * @author lvfq
 * @date 2017/5/3 下午3:19
 * @mainFunction :
 */
public class UseReentrantReadWriteLock {
    /**
     * ReentrantReadWriteLock 读读共享，读写互斥，写写互斥
     */
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private void read() {
        try {
            readLock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " , 进入 read ..");
            Thread.sleep(3000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " , 结束 read ..");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    private void write() {
        try {
            writeLock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " , 进入 write ..");
            Thread.sleep(3000);
            System.out.println("当前线程 " + Thread.currentThread().getName() + " , 结束 write ..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        UseReentrantReadWriteLock lock = new UseReentrantReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.read();
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.read();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.write();
            }
        }, "t3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.write();
            }
        }, "t4");

//        t1.start();
//        t2.start();
        t3.start();
        t4.start();

    }

}
