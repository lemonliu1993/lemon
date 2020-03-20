package com.lemon.framework.advice;

import com.lemon.framework.aop.AfterReturningAdvice;
import com.lemon.framework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:14 AM
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice{

    public void afterReturning(Object result, Method method, Object[] args, Object target) {
        System.out.println("After");
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before");
    }
}
