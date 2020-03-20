package com.lemon.framework.aop;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:10 AM
 */
public interface AfterReturningAdvice {

    void afterReturning(Object result, Method method,Object[] args,Object target);
}
