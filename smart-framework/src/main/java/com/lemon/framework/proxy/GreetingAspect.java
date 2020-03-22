package com.lemon.framework.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 2020/3/22 7:53 PM
 */

@Aspect
@Component
public class GreetingAspect {

    @Around("execution(*aop.demo.GreetingImpl.*(,,,))")
    public Object arount(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
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
