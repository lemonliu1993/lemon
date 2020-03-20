package com.lemon.framework.advice;


import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:48 AM
 */
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("--------- Throw Exception -----------");
        System.out.println("Target Class: " + target.getClass().getName());
        System.out.println("Method Name: " + method.getName());
        System.out.println("Exception Message: " + e.getMessage());
        System.out.println("-------------------------------------");
    }
}
