package com.dev.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Resource
    @Qualifier("druidDataSource02")
    DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        // Sets the SpringBootVFS class into SqlSessionFactoryBean
        return factoryBean.getObject();
    }

    // 事务支持
    @Bean
    public PlatformTransactionManager transactionManager(){
        return  new DataSourceTransactionManager(dataSource);
    }
}
