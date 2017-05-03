package com.lvfq.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * UseManyCondition
 *
 * @author lvfq
 * @date 2017/5/3 下午2:17
 * @mainFunction :
 */
public class UseManyCondition {

    /**
     * ReentrantLock 下的 Condistion 可以同时创建多个，也就是，可以分开控制不同的线程，唤醒指定线程，剩下的继续等待。
     * ReentrantLock 可传一个 boolean 类型的参数， 表示公平 或者非公平。 默认为 非公平。
     * 公平锁是需要维护一个代码执行顺序的，非公平锁不用维护，所以 ，非公平锁效率高与 公平锁。
     */
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();


    private void m1() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 m1  等待...");

            c1.await();

            System.out.println("当前线程 " + Thread.currentThread().getName() + "  m1 继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void m2() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 m2 等待...");

            c1.await();

            System.out.println("当前线程 " + Thread.currentThread().getName() + "  m2 继续执行...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void m3() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 m3 等待...");
            System.out.println("获取当前调用锁的个数" + lock.getHoldCount());
            c2.await();

            System.out.println("当前线程 " + Thread.currentThread().getName() + "  m3 继续执行...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void m4() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 m4 , 唤醒 c1 等待的线程...");
            c1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private void m5() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 进入 m5 唤醒 c2 等待的线程");
            c2.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UseManyCondition condition = new UseManyCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                condition.m1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                condition.m2();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                condition.m3();
            }
        }, "t3");



        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                condition.m4();
            }
        }, "t4");

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                condition.m5();
            }
        }, "t5");


        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.start();
    }


}
