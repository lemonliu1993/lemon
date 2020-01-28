package com.lemon.test;

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

        BookDao bean1 = applicationContext.getBean(BookDao.class);
        System.out.println(bean1);

        applicationContext.close();
    }
}
