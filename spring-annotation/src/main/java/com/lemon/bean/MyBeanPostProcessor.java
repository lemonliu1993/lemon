package com.lemon.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * 后置处理器，初始化前后进行处理工作
 * 将后置处理器加入容器中
 * Created by lemoon on 20/1/27 下午9:06
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    public Object postProcessBeforeInitialization(Object bean, String beanNane) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+beanNane+"=>"+bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanNane) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+beanNane+"=>"+bean);
        return bean;
    }
}
