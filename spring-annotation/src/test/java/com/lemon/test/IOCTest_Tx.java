package com.lemon.test;

import com.lemon.aop.MathCalculator;
import com.lemon.config.MainConfigOfAOP;
import com.lemon.tx.TxConfig;
import com.lemon.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lemoon on 20/1/28 下午6:17
 */
public class IOCTest_Tx {

    @Test
    public void test01(){

        //1.不要自己创建对象，只有Spring容器中的才能使用切面
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();

        applicationContext.close();
    }
}
