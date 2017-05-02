package com.lvfq.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Runner
 *
 * @author lvfq
 * @date 2017/5/2 下午5:25
 * @mainFunction :
 */
public class Runner implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public Runner(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random().nextInt(5)));
            System.out.println(name + " 准备Ok");
            // 在不同的线程中，当 await 调用的次数 达到初始化的数量时。所有线程同时继续执行。
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(name + " 开始跑" + " ， time" + System.currentTimeMillis());
    }
}
