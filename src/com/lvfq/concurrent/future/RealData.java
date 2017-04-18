package com.lvfq.concurrent.future;

import java.util.concurrent.TimeUnit;

/**
 * RealData
 *
 * @author lvfq
 * @date 2017/4/18 上午9:41
 * @mainFunction :
 */
public class RealData {

    private String data;

    public RealData(String data) throws InterruptedException {
        System.out.println("模拟数据加载中。。。");
        TimeUnit.SECONDS.sleep(5);
        this.data = data;
    }

    public String getResult() {
        return data + " - real data";
    }
}
