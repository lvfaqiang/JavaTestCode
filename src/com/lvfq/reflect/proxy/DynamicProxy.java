package com.lvfq.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * DynamicProxy
 *
 * @author lvfq
 * @date 2017/5/26 下午4:00
 * @mainFunction :
 */
public class DynamicProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start perform");
        System.out.println(method.getDeclaringClass());
        return "测试内容";
    }
}
