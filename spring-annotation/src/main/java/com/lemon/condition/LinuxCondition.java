package com.lemon.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by lemoon on 20/1/27 上午8:24
 * 判断是否Linux系统
 */
public class LinuxCondition implements Condition {

    /**
     * @param context  判断条件能使用的上下文(环境)
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //TODO 是否Linux系统
        //1。能获取道ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        //3.获取当前环境
        Environment environment = context.getEnvironment();

        //4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");

        //可以判断容器中的bean注册情况，也恶意给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");

        if (property.contains("Mac") || property.contains("Linux")) {
            return true;
        }
        return false;
    }
}


