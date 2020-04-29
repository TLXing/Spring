package com.dev.test;

import com.dev.util.RedisHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class Test01 {
    @Resource(name = "druidDataSource02")
    DataSource dataSource;
    @Test
    void Test01(){

        //Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT * FROM books");
        System.out.println( srs.getMetaData().getColumnCount());
        System.out.println(RedisHelper.getString("name"));
        System.out.println("Test01");
    }
}
