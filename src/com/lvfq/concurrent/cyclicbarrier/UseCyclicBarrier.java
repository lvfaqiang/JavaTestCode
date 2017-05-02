package com.lvfq.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * UseCyclicBarrier
 *
 * @author lvfq
 * @date 2017/5/2 下午5:02
 * @mainFunction :
 */
public class UseCyclicBarrier {

    public static void main(String[] args) {
        /**
         *  参数表示当前需要有多少个 await()方法调用 同一个线程中，重复调用无效。
         *  当三个线程都调用了 await 方法之后，三个线程会同时继续执行。
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Thread(new Runner(cyclicBarrier, "施强")));
        service.submit(new Thread(new Runner(cyclicBarrier, "思晗")));
        service.submit(new Thread(new Runner(cyclicBarrier, "柴高")));

        service.shutdown();
    }
}
