package com.lvfq.master_worker;

import java.util.Map;

/**
 * Client
 *
 * @author lvfq
 * @date 2017/4/26 下午3:04
 * @mainFunction :
 */
public class Client {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        Master master = new Master(count);
        for (int i = 0; i < (count * 2); i++) {
            Task task = new Task(i + 1, "name" + (i + 1));
            master.add(task);
        }

        System.out.println("线程数：" + count);
        long start = System.currentTimeMillis();
        master.execute();

        while (true) {
            if (master.isComplete()) {
                System.out.println("execute time : " + (System.currentTimeMillis() - start));
                Map<String, String> map = master.getResultMap();
                for (Map.Entry<String, String> en :
                        map.entrySet()) {
                    System.out.println("result : " + en.getKey() + " , " + en.getValue());
                }
                break;
            }
        }
    }
}
