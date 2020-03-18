package com.lemon.framework.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lemoon on 2020/3/18 9:54 PM
 */
public class DynamicProxy implements InvocationHandler {

    //被代理的目标对象
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }


    private void before() {
        System.out.println("before! dynamic");
    }


    private void after() {
        System.out.println("after! dynamic");

    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
