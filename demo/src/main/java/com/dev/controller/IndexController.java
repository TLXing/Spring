package com.dev.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
public class IndexController {

    @Resource(name = "druidDataSource02")
    DataSource dataSource;

    @GetMapping("/hello")
    public String hello(){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT * FROM books");
        System.out.println( srs.getMetaData().getColumnCount());
        return "Hello World";
    }
}
