package com.lemon.framework.aspect;

import com.lemon.framework.annotation.Aspect;
import com.lemon.framework.annotation.Controller;
import com.lemon.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截Controller所有方法
 * Created by lemoon on 2020/4/6 11:41 PM
 */

@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy{

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {

        LOGGER.debug("--------begin--------");
        LOGGER.debug(String.format("class:%s",cls.getName()));
        LOGGER.debug(String.format("method:%s",method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {

        LOGGER.debug(String.format("time:%dms",System.currentTimeMillis()-begin));
        LOGGER.debug("---------end----------");
    }
}
