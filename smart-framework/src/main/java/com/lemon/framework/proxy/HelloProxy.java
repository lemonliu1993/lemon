package com.lemon.framework.proxy;

/**
 * Created by lemoon on 2020/3/18 9:15 AM
 */
public class HelloProxy implements Hello{

    private Hello hello;

    public HelloProxy(){
        hello = new HelloImpl();
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }


}
