package com.dev.mapper;

import com.dev.entity.Author;
import com.dev.entity.AuthorExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    int countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}