package com.lemon.framework.annotation;

import com.sun.tools.javac.code.Attribute;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务类注解
 * Created by lemoon on 2020/3/6 8:39 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy



        .RUNTIME)
public @interface Service {

}
