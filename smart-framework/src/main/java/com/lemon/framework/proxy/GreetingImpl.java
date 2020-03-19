package com.lemon.framework.proxy;

/**
 * Created by lemoon on 2020/3/19 7:40 PM
 */
public class GreetingImpl implements Greeting{

    public void sayHello(String name) {
        before();
        System.out.println("Hello!"+name);
        after();
    }


    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
