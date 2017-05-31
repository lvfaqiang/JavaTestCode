package com.lvfq.reflect.proxy;

/**
 * RealSubject
 *
 * @author lvfq
 * @date 2017/5/26 上午9:21
 * @mainFunction :
 */
public class ProxySubject implements Subject {

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String doSomething() {
        System.out.println("调用真实数据前的操作");
        if (realSubject != null) {
            realSubject.doSomething();
        }
        System.out.println("代理收尾处理");
        return "";
    }
}
