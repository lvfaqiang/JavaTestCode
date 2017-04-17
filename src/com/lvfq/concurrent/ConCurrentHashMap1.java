package com.lvfq.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * ConCurrentHashMap1
 *
 * @author lvfq
 * @date 2017/4/15 上午10:39
 * @mainFunction :
 */
public class ConCurrentHashMap1 {

    /**
     * ConCurrentHashMap 属于线程安全。内部分16个段 (segment,也就是可同时并发 16个线程).
     */
    private static Map<String, String> map = new ConcurrentHashMap<>();


    private void put(String key, String value) {
        map.put(key, value);
    }

    private void remove(String key) {
        map.remove(key);
    }

    private int getSize() {
        return map.size();
    }


    public static void main(String[] args) {

        ConCurrentHashMap1 map1 = new ConCurrentHashMap1();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName());
                map1.put("key1", "value1");
                System.out.println("当前线程：" + Thread.currentThread().getName() + " size : " + map1.getSize());

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName());
                map.put("key2", "value2");
                System.out.println("当前线程：" + Thread.currentThread().getName() + " size : " + map1.getSize());
            }
        }, "t2");

        for (int i = 0; i < 10; i++) {
            final int pos = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put("key" + pos, "value" + pos);
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " size : " + map1.getSize());
                }
            }, "t" + i);
            thread.start();
        }
//        t2.start();
//        t1.start();
    }
}
