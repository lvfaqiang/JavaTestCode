package com.lvfq.socket;

import java.util.concurrent.*;

/**
 * HandlerExecutors
 *
 * @author lvfq
 * @date 2017/5/8 下午12:32
 * @mainFunction :
 */
public class HandlerExecutorsPool {

    private ExecutorService executors;

    public HandlerExecutorsPool(int maxPoolSize, int queueSize) {
        executors = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize)
        );
    }

    public void execute(Runnable runnable) {
        executors.execute(runnable);
    }
}
