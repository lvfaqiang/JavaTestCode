package com.lvfq.master_worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Worker
 *
 * @author lvfq
 * @date 2017/4/26 下午3:04
 * @mainFunction :
 */
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> queue;
    private ConcurrentHashMap<String, String> resultMap;

    public void setQueue(ConcurrentLinkedQueue<Task> queue) {
        this.queue = queue;
    }

    public void setResultMap(ConcurrentHashMap<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            Task task = queue.poll();   // poll 获取头元素 并删除。 peek 获取头元素不删除。
            if (task == null) {
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(3);
                resultMap.put("id:" + task.getId(), task.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
