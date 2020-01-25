package com.lemon.config;

import com.lemon.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类＝配置文件
 * Created by lemoon on 20/1/25 下午5:28
 */

@Configuration  //告诉Spring这是一个配置类
public class MainConfig {

    //给容器中注册一个bean;类型为返回值的类型，id默认是方法名作为
    @Bean("person02")
    public Person person01(){
        return new Person("lisi",20);
    }
}
