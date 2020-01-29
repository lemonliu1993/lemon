package com.lemon.config;

import com.lemon.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖赋值
 *
 *  1).@Autowired.自动注入
 *      1）默认有限按照类型去容器中找对应的组件：BookDao bean1 = applicationContext.getBean(BookDao.class);
 *      2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *                      applicationContext.getBean("bookDao")
 *      3)@Qualifier("bookDao")使用@Qualifier制定需要装配的组件的id，而不是使用属性名
 *      4)自动装配一定要将属性赋值好，没有就会报错
 *          可以使用@Autowired(required=false);
 *      5）@Primary让Spring进行自动装配的时候，默认使用首选的bean
 *          也可以继续使用@Qualifier指定需要装配的bean的名字
 *      @Service
        public class BookService {

        @Autowired
        private BookDao bookDao;
        }

 *  2)Spring还支持使用@Resource(JSR250(和@Inject(JSR330)  [java规范的注解]，其他的是Spring规范
 *      @Resource:
 *          可以和@Autowired一样实现自动装配，java规范，默认是按照组件名称进行装配的
 *          没有能支持@Primary功能没有支持@Autowired(required=false);
 *      @Inject:
 *          需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能
 *   @Autowired：Spring定义的；@Resource，@Inject，@Inject都是java规范。
 *
 *   AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能
 *
 *
 *
 * Created by lemoon on 20/1/28 下午6:14
 */
@Configuration
@ComponentScan({"com.lemon.service","com.lemon.dao","com.lemon.controller"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }


}