package com.lemon.test;

import com.lemon.bean.Person;
import com.lemon.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by lemoon on 20/1/28 下午4:17
 */
public class IOCTest_PropertyValue {

    //1.创建ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);


    @Test
    public void test01(){

        printBeans(applicationContext);
        System.out.println("===============");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);


        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        applicationContext.close();;
    }



    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
