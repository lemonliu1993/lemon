package com.lemon.test;

import com.lemon.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/25 下午5:45
 */
public class IOCTest {


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
