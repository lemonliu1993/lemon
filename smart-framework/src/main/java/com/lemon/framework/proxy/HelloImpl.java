package com.lemon.framework.proxy;

/**
 * Created by lemoon on 2020/3/18 9:05 AM
 */
public class HelloImpl implements Hello{
    public void say(String name) {
        System.out.println("Hello! "+name);
    }
}
