package com.lvfq.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * CustomRejected
 *
 * @author lvfq
 * @date 2017/5/2 下午3:40
 * @mainFunction : 自定义拒绝策略
 */
public class CustomRejected implements RejectedExecutionHandler {

    public CustomRejected() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // TODO: 2017/5/2 do something
        System.out.println("自定义处理...");
        UseThreadPoolExecutor1.MyTask task = (UseThreadPoolExecutor1.MyTask) r;
        System.out.println("当前被拒绝任务：id :" + task.getId() + " , Name :" + task.getTaskName());
    }
}
