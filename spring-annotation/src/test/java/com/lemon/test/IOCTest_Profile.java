package com.lemon.test;

import com.lemon.bean.Boss;
import com.lemon.bean.Car;
import com.lemon.bean.Color;
import com.lemon.config.MainConfigOfAutowired;
import com.lemon.config.MainConfigOfProfile;
import com.lemon.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Created by lemoon on 20/1/28 下午6:17
 */
public class IOCTest_Profile {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : beanNamesForType){
            System.out.println(string);
        }

        applicationContext.close();
    }
}
