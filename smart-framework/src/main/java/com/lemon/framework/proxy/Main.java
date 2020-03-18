package com.lemon.framework.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by lemoon on 2020/3/18 10:10 PM
 */
public class Main {
    public static void main(String[] args) {
//        Hello hello = new HelloImpl();

//        DynamicProxy dynamicProxy = new DynamicProxy(hello);
//
//        //Proxy.newProxyInstance方法需要参数：1。ClassLoader，2。该实现类的所有接口，3。动态代理对象
//        Hello helloProxy = (Hello) Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                dynamicProxy
//        );
//        helloProxy.say("Jack");
//        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
//        Hello helloProxy = dynamicProxy.getProxy();
//        helloProxy.say("jack");

        DynamicProxy dynamicProxy1 = new DynamicProxy(new HelloService());
        HelloService proxy = dynamicProxy1.getProxy();
        proxy.say("sss");


    }
}
