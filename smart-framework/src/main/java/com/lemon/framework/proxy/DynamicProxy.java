package com.lemon.framework.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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




}
