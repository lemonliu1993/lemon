package com.lemon.test;

import com.lemon.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/27 下午3:40
 */
public class IOCTest_LifeCycle {


    @Test
    public void test01(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");


        //关闭容器
        annotationConfigApplicationContext.close();

    }
}
