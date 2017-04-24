package com.lvfq.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * RealData_1
 *
 * @author lvfq
 * @date 2017/4/18 下午10:33
 * @mainFunction :
 */
public class RealData_1 implements Callable<String> {

    private String data;

    public RealData_1(String data) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("real data 1");
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        System.out.println("real data 1 call()");
        return data;
    }
}
