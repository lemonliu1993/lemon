package com.lemon.framework;

import com.lemon.framework.annotation.Controller;
import com.lemon.framework.helper.BeanHelper;
import com.lemon.framework.helper.ClassHelper;
import com.lemon.framework.helper.ControllerHelper;
import com.lemon.framework.helper.IocHelper;
import com.lemon.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * Created by lemoon on 2020/3/16 10:08 AM
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }


}
