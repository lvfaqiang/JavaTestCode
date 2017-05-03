package com.lvfq.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * UseSemaphore
 *
 * @author lvfq
 * @date 2017/5/3 上午10:45
 * @mainFunction :
 * Semaphore 信号量测试。
 */
public class UseSemaphore {


    public static void main(String[] args) {
        // 线程池
        ExecutorService service = Executors.newCachedThreadPool();

        // 信号量实例，  参数表示最多只能五个线程同时执行，进行限流。
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        System.out.println("线程对象： " + num);
                        // 模拟实际业务处理。
                        Thread.sleep(1000 * (new Random().nextInt(5))); // 休眠 0-5秒的随机时间
                        // 访问成功之后，释放。
                        semaphore.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            service.execute(runnable);
        }

        service.shutdown();

    }
}
