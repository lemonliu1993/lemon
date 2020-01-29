package com.lemon.test;

import com.lemon.bean.Boss;
import com.lemon.bean.Car;
import com.lemon.bean.Color;
import com.lemon.config.MainConfigOfAutowired;
import com.lemon.dao.BookDao;
import com.lemon.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/28 下午6:17
 */
public class IOCTest_Autowired {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);


        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println(bean);

//        BookDao bean1 = applicationContext.getBean(BookDao.class);
//        System.out.println(bean1);


        Boss bean1 = applicationContext.getBean(Boss.class);
        System.out.println(bean1);

        Car bean2 = applicationContext.getBean(Car.class);
        System.out.println(bean2);


        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        applicationContext.close();
    }
}
