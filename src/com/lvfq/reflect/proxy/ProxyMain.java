package com.lvfq.reflect.proxy;

import java.lang.reflect.Proxy;

/**
 * ProxyMain
 *
 * @author lvfq
 * @date 2017/5/26 上午9:22
 * @mainFunction :
 */
public class ProxyMain {

    public static void main(String[] args) {

        /**
         * 静态代理
         */
//        ProxySubject proxySubject = new ProxySubject(new RealSubject());
//        proxySubject.doSomething();

        DynamicProxy proxy = new DynamicProxy();
        Subject p = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), new Class[]{Subject.class}, proxy);
        System.out.println(p.doSomething());
    }
}

