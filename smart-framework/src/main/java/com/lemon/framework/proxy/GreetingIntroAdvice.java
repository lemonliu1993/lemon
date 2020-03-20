package com.lemon.framework.proxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by lemoon on 2020/3/20 10:31 AM
 */
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
