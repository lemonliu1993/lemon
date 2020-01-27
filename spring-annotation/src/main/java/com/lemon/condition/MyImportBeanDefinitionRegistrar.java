package com.lemon.condition;

import com.lemon.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by lemoon on 20/1/27 下午12:52
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry:BeanDefinition注册类；
     *                把所有需要添加到容器中的bean
     *                BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.lemon.bean.Red");
        boolean definition2 = registry.containsBeanDefinition("com.lemon.bean.Blue");
        if(definition && definition2){
            //指定bean定义信息,(Bean的类型，Bean......)
            //beanDefinition
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean，指定bean名
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }

    }
}
