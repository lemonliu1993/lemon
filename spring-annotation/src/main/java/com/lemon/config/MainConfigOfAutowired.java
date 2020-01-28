package com.lemon.config;

import com.lemon.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖赋值
 *
 *  1).@Autowired.自动注入
 *      1）默认有限按照类型去容器中找对应的组件：BookDao bean1 = applicationContext.getBean(BookDao.class);
 *      2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *                      applicationContext.getBean("bookDao")
 *      @Service
        public class BookService {

        @Autowired
        private BookDao bookDao;
        }

 * Created by lemoon on 20/1/28 下午6:14
 */
@Configuration
@ComponentScan({"com.lemon.service","com.lemon.dao","com.lemon.controller"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }


}
