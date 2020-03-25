package com.lemon.framework.aspect;

import com.lemon.framework.proxy.Apology;
import com.lemon.framework.proxy.ApologyImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 2020/3/23 2:41 PM
 */
@Aspect
@Component
public class GreetingAspect {

    /**
     * 在Aspect类中定义一个需要引入增强的接口，他也就是运行时需要动态代理的接口。在这个接口上标注了DeclareParents注解，该注解有两个属性：
     * Value——目标类
     * defaultImpl——引入接口的默认实现类
     */
    @DeclareParents(value = "com.lemon.framework.proxy.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

    @Around("@annotation(com.lemon.framework.annotation.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //TODO
        return null;
    }
}
