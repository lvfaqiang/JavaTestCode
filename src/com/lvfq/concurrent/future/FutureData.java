package com.lvfq.concurrent.future;

/**
 * FutureData
 *
 * @author lvfq
 * @date 2017/4/18 上午9:40
 * @mainFunction :
 */
public class FutureData implements Data {

    private boolean isReady;
    private RealData data;

    public synchronized void setRequest(RealData data) {
        if (isReady) {
            return;
        }
        this.data = data;
        isReady = true;
        notify();
    }

    @Override
    public synchronized String getResult() throws InterruptedException {
        if (!isReady) {
            System.out.println("等待数据返回中。。。");
            wait();
        }
        return data.getResult();
    }
}
