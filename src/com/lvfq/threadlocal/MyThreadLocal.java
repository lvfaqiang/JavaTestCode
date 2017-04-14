package com.lvfq.threadlocal;

/**
 * MyThreadLocal
 *
 * @author lvfq
 * @date 2017/4/14 下午4:47
 * @mainFunction :
 */
public class MyThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private void setName(String string) {
        threadLocal.set(string);
    }

    private void getTh() {
        System.out.println(Thread.currentThread().getName() + " : " + threadLocal.get());
    }

    public static void main(String[] args) {
        MyThreadLocal tl = new MyThreadLocal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                tl.setName("张三");
                tl.getTh();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tl.getTh();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
