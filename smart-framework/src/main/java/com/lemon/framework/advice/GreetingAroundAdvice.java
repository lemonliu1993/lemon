package com.lemon.framework.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:15 AM
 */
public class GreetingAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
