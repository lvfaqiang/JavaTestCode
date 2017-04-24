package com.lvfq.concurrent.future;

import java.util.concurrent.*;

/**
 * Main
 *
 * @author lvfq
 * @date 2017/4/18 上午9:32
 * @mainFunction :
 */
public class Main {
    /**
     * Futrue 设计模式，
     * client端 发送某个耗时请求 - >  FutrueData 代理对象 先返回一个 假对象，然后其内部开启线程进行真实请求操作 -- >  RealData 真实处理对象，处理结束之后，回调数据给 代理对象，代理对象再进行通知 client端
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Client client = new Client();
//        Data data = client.setRequest("this is test");
//        System.out.println("main ： " + System.currentTimeMillis());
//        System.out.println(data.getResult());

        /**
         * Java jdk 内置 FutureTask 是一个线程类，必须使用配合线程池调用。
         */
        FutureTask futureTask = new FutureTask(new RealData_1("this is test jdk future"));
        ExecutorService exe = Executors.newFixedThreadPool(1);

        exe.submit(futureTask);

        System.out.println(futureTask.get());

    }

}
