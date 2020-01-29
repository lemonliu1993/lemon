package com.lemon.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile:
 * Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * <p>
 * 开发环境，测试环境，生产环境：
 * 数据源:(/A)(/B)(/C)
 * Created by lemoon on 20/1/29 下午5:41
 */

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

    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

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
