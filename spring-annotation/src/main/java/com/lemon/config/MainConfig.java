package com.lemon.config;

import com.lemon.bean.Person;
import com.lemon.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类＝配置文件
 * Created by lemoon on 20/1/25 下午5:28
 */

@Configuration  //告诉Spring这是一个配置类

@ComponentScans(value = {
        @ComponentScan(value = "com.lemon", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class
//                }),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})

        }, useDefaultFilters = false)
})
//@ComponentScan(value = "com.lemon") value：指定要扫描的包
//excludeFilters=Filter[]:指定扫描的时候按照什么规则排除哪些组件
//includeFilters=Filter[]:指定扫描的时候只需要包含哪些组件
//Filter.ANNOTATION:按照注解
//Filter.ASSIGNABLE_TYPE:按照给定的类型
//FilterTye.ASPECTJ:使用ASPECTJ表达式
//FilterType.REGEX:使用正则表达式
//FilterType.
public class MainConfig {

    //给容器中注册一个bean;类型为返回值的类型，id默认是方法名作为
    @Bean("person02")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
