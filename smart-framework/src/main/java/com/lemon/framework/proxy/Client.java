package com.lemon.framework.proxy;

/**
 * Created by lemoon on 2020/3/19 7:46 PM
 */
public class Client {
    public static void main(String[] args) {
        Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");
    }
}
