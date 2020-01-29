package com.lemon.bean;

import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 20/1/27 下午3:30
 */

@Component
public class Car {

    public Car(){
        System.out.println("car  constructor...");
    }

    public void init(){
        System.out.println("car ...init");
    }

    public void destroy(){
        System.out.println("car ...destroy");
    }
}
