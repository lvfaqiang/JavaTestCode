package com.lvfq.concurrent.future;

/**
 * Client
 *
 * @author lvfq
 * @date 2017/4/18 上午9:33
 * @mainFunction :
 */
public class Client {

    public Data setRequest(String requestString) {
        FutureData data = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("client run : " + System.currentTimeMillis());
                    data.setRequest(new RealData(requestString));// 当 RealData 的构造方法执行完成之后，才会进入到 setRequest的方法中。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return data;
    }

}
