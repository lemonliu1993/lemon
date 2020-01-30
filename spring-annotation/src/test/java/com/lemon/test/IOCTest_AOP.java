package com.lemon.test;

import com.lemon.aop.MathCalculator;
import com.lemon.bean.Boss;
import com.lemon.bean.Car;
import com.lemon.bean.Color;
import com.lemon.config.MainConfigOfAOP;
import com.lemon.config.MainConfigOfAutowired;
import com.lemon.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/28 下午6:17
 */
public class IOCTest_AOP {

    @Test
    public void test01(){

        //1.不要自己创建对象，只有Spring容器中的才能使用切面
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1,1);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,0);


        applicationContext.close();
    }
}
