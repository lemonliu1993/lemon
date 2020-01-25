package com.lemon;

import com.lemon.bean.Person;
import com.lemon.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lemoon on 20/1/25 下午5:19
 */
public class Main {

    public static void main(String[] args) {
//        Person p = new Person();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) ctx.getBean("person");
//        System.out.println(person);


        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person p = ctx1.getBean(Person.class);
        System.out.println(p);

        String[] namesForType = ctx1.getBeanNamesForType(Person.class);
        //id 默认是方法名,也可以通过@Bean的value指定
        for(String name:namesForType){
            System.out.println(name);
        }
    }
}
