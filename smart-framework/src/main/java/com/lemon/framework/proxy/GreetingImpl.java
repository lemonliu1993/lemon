package com.lemon.framework.proxy;

import com.lemon.framework.annotation.Service;
import com.lemon.framework.annotation.Tag;

/**
 * Created by lemoon on 2020/3/19 7:40 PM
 */

@Service
public class GreetingImpl implements Greeting {


    @Tag
    public void sayHello(String name) {
        before();
        System.out.println("Hello!" + name);
        after();
    }


    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }
}
