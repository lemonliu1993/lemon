package com.lemon.test;

import com.lemon.config.MainConfig;
import com.lemon.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/25 下午5:45
 */
public class IOCTest {

    @SuppressWarnings("resource")
    @Test
    public void test02(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = ctx.getBeanDefinitionNames();
//        for(String name: definitionNames){
//            System.out.println(name);
//        }
//
        System.out.println("ioc容器创建完成......");
        Object person = ctx.getBean("person");
        Object person2 = ctx.getBean("person");
//        System.out.println(person==person2);
    }



    @SuppressWarnings("resource")
    @Test
    public void test01(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = ctx.getBeanDefinitionNames();
        for(String name: definitionNames){
            System.out.println(name);
        }
    }
}
