package com.lemon.framework.aop;

import java.lang.reflect.Method;

/**
 * Created by lemoon on 2020/3/20 9:09 AM
 */
public interface MethodBeforeAdvice {
    
    void before(Method method, Object[] args, Object target) throws Throwable;

}
