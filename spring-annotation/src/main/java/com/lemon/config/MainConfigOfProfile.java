package com.lemon.config;

import com.lemon.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile:
 * Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * <p>
 * 开发环境，测试环境，生产环境：
 * 数据源:(/A)(/B)(/C)
 *
 *
 * @Profile:指定组件在哪个环境下才能被注册倒容器中，不指定，任何环境下都能注册这个组件
 * 1)加了环境标识的bean，只有这个环境被激活的时候才能被注册倒容器中
 * 2)写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）没有标注环境标识的bean在任何环境下都是加载的
 *
 * Created by lemoon on 20/1/29 下午5:41
 */

@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {


    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;


        this.driverClass = valueResolver.resolveStringValue("${db.driver}");

    }


//    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

//    @Profile("default")
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
}
