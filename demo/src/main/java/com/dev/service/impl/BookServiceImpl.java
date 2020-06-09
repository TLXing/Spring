package com.dev.service.impl;

import com.dev.entity.Book;
import com.dev.mapper.BookMapper;
import com.dev.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }


    @Override
    /**
     *  @Transactional
     *  参数 propagation 事务传播方式
     *  参数 isolation 事务隔离级别
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(){
//        Book b = new Book();
//        b.setId(1);
//        b.setTitle("A");
//        b.setPrice(new BigDecimal("1231232"));
//        int a =  bookMapper.updateByPrimaryKey(b);
        Book dd = bookMapper.selectByPrimaryKey(1);
        System.out.println(dd.toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i=1/1;
         f();
        Book ddc = bookMapper.selectByPrimaryKey(1);
        System.out.println(ddc.toString());
//        int i = 1/0;
//        b.setTitle("C");
//        b.setId(3);
//        int c =  bookMapper.updateByPrimaryKey(b);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void f(){

    }

}
