package com.lvfq.reflect.proxy;

/**
 * RealSubject
 *
 * @author lvfq
 * @date 2017/5/26 上午9:21
 * @mainFunction :
 */
public class RealSubject implements Subject {
    @Override
    public String doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是 RealSubject 处理结果");
        return "";
    }
}
