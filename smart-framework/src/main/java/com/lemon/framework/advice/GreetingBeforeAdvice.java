package com.lemon.framework.advice;

import com.lemon.framework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:05 AM
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before");
    }
}
