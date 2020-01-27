package com.lemon.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by lemoon on 20/1/27 下午12:32
 * 自定义逻辑返回需要导入的组件
 */
public class MyImortSelector implements ImportSelector{

    /**
     * 返回值，就是要导入到容器中的组件全类名
     * AnnotationMetadata:当前标注@Import注解的类的所有注解信息
     * @param importingClassMetadata
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        return new String[]{"com.lemon.bean.Blue","com.lemon.bean.Yellow"};
        //方法不要返回null值
//        return null;
    }
}
