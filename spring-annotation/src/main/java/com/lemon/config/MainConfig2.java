package com.lemon.config;

import com.lemon.bean.Person;
import com.lemon.condition.LinuxCondition;
import com.lemon.condition.WindowCondition;
import org.springframework.context.annotation.*;

/**
 * Created by lemoon on 20/1/26 下午2:17
 */

@Configuration
//类中组件统一设置，满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({LinuxCondition.class})
public class MainConfig2 {
    //默认是单实例的

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * @return
     *
     * prototype:多实例的:ioc容器启动并不会去调用方法创建对象放在容器中，
     *          每次获取的时候才会调用方法创建对象。
     * singleton：单实例的(默认值),ioc容器启动会调用方法创建对象放到ioc容器中。
     *          以后每次获取就是直接从容器(map.get)中拿。
     * request:同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     *  单实例bean，默认再容器启动的时候创建对象
     *  懒加载：容器启动不创建对象，第一次使用(获取)Bean创建对象，并初始化。
     *
     */
    //@Scope 调整作用域
//    @Scope("prototype")
//    @Scope
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person......");
        return new Person("张三", 24);
    }


    /**
     * @Conditional,按照一定条件进行判断,满足条件给容器注册bean
     *
     * 如果系统是windows,给容器中注册bill
     * 如果系统是linux，给容器中注册linus
     */
    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }
}
