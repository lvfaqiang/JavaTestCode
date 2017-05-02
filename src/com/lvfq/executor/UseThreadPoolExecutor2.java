package com.lvfq.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UseThreadPoolExecutor2
 *
 * @author lvfq
 * @date 2017/5/2 上午10:02
 * @mainFunction : 测试无界队列的线程池
 */
public class UseThreadPoolExecutor2 implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            int count = atomicInteger.getAndIncrement();
            System.out.println("run count : " + count);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 60l, TimeUnit.SECONDS, queue);

        for (int i = 0; i < 20; i++) {
            executor.execute(new UseThreadPoolExecutor2());
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("queue size : " + queue.size());
        TimeUnit.SECONDS.sleep(2);
    }
}
