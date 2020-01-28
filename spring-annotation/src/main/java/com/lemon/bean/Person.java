package com.lemon.bean;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lemoon on 20/1/25 下午5:15
 */
//@Data
//@Accessors
public class Person {



    //使用@Value赋值：
    //1.基本数值
    //2.可以写SpEL，#{}
    //3.可以写${},取出配置文件中的值(配置文件中的最后写到 在运行环境变量里面的值)
    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
