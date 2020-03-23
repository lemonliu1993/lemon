package com.lemon.framework.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 2020/3/22 7:53 PM
 * 类上面标注的Aspect注解表明该类是一个Aspect(其实就是Advisor)。该类无需实现任何的接口，只需定义一个方法(方法名叫什么都无所谓)
 * 在方法上标注@Around注解，在注解中使用Aspect切点表达式。方法中的参数中包括一个ProceedingJointPoint对象，
 * 它在AOP中称为JointPoint(连接点)，可以通过该对象获取方法的任何信息,例如，方法名，参数等
 */

@Aspect
@Component
public class GreetingAspect {


    /**
     * execution(* com.lemon.framework.proxy.GreetingImpl.*(..))
     * execution()表示拦截方法，括号中可定义需要匹配的规则：
     * 第一个*表示方法的返回值是任意的；
     * 第二个*表示匹配该类中所有的方法；
     * (..)表示方法的参数是任意的
     */
    @Around("execution(* com.lemon.framework.proxy.GreetingImpl.*(..))")
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
