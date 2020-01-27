package com.lemon.test;

import com.lemon.bean.Person;
import com.lemon.config.MainConfig;
import com.lemon.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Created by lemoon on 20/1/25 下午5:45
 */
public class IOCTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void testImport() {
        printBeans(ctx);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {

        Environment environment = ctx.getEnvironment();
//        ConfigurableEnvironment environment =
        String property = environment.getProperty("os.name");
        //Mac OS X
        System.out.println(property);

        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = ctx.getBeansOfType(Person.class);
        System.out.println(persons);
    }


    @SuppressWarnings("resource")
    @Test
    public void test02() {
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
    public void test01() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = ctx.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
