package com;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationStart.class,args);
    }
}
