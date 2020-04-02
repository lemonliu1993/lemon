package com.lemon.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by lemoon on 2020/4/2 3:28 PM
 *
 * 通过@Target(ElementType.TYPE)来设置该注解只能应用于类上。
 * 该注解中包含一个名为value的属性，它是一个注解类，用勒定义Controller这类注解。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
