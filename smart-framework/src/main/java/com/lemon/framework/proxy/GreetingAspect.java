package com.lemon.framework.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
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
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    /**
     * 除了Around注解外，还有几个相关的注解
     * Before——前置增强
     * After——后置增强
     * Around——环绕增强
     * AfterThrowing——抛出增强
     * DeclareParents——引入增强
     * 此外还有一个AfterReturning(返回后增强)，也可以理解为Finally增强，相当于finally语句，
     * 它是在方法结束后执行的，也就是说，它比After还要晚一些。
     */

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }


    /**
     * 在Aspect类中定义一个需要引入增强的接口，它也就是运行时需要动态实现的接口。
     * 在这个接口上标注类DeclareParents注解，该注解有两个属性：
     * Value---目标类
     * defaultImpl---引入接口的默认实现类
     */
    @DeclareParents(value = "com.lemon.framework.proxy.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;


}
