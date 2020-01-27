package com.lemon.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by lemoon on 20/1/27 下午6:08
 */

@Component
public class Cat implements InitializingBean,DisposableBean{

    public Cat(){
        System.out.println("Cat constructor......");
    }

    public void destroy() throws Exception {
        System.out.println("Cat destroy......");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat afterPropertiesSet......");

    }
}
