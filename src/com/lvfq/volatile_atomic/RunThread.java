package com.lvfq.volatile_atomic;

/**
 * RunThread
 *
 * @author lvfq
 * @date 2017/4/14 上午8:56
 * @mainFunction :
 */
public class RunThread extends Thread {

    private volatile boolean isRunning;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入线程。。。");
        while (isRunning) {
            // do something
        }
        System.out.println("线程结束");
    }

    public static void main(String[] arg0) throws InterruptedException {
        RunThread t1 = new RunThread();
        t1.start();
        Thread.sleep(3000);
        t1.setRunning(false);
        Thread.sleep(1000);
        System.out.println("t1 isRunnung : " + t1.isRunning);
    }
}
