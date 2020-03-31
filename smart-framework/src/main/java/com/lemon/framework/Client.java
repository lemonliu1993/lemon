package com.lemon.framework;

import com.lemon.framework.proxy.Apology;
import com.lemon.framework.proxy.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lemoon on 2020/3/31 1:53 PM
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-config.xml");
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("Jack");

        Apology apology = (Apology)greeting;    //强制转型为Apology接口
        apology.saySorry("Jack");
    }
}
