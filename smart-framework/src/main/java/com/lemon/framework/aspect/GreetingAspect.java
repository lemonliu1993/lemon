package com.lemon.framework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 2020/3/23 2:41 PM
 */
@Aspect
@Component
public class GreetingAspect {

    @Around("@annotation(com.lemon.framework.annotation.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //TODO
        return null;
    }
}
