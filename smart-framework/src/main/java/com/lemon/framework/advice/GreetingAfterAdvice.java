package com.lemon.framework.advice;

import com.lemon.framework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:11 AM
 */
public class GreetingAfterAdvice implements AfterReturningAdvice{
    public void afterReturning(Object result, Method method, Object[] args, Object target) {
        System.out.println("After");
    }
}
