package com.imooc.imooc1.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
@MapperScan("com.imooc.imooc1.config.dao")//配置mybatis的扫描路径
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")//创建一个bean，注入到容器
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //先创建一个出来
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //再给他一些属性
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //关闭链接后不自动commit
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
