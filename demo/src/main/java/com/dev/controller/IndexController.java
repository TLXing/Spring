package com.dev.controller;

import com.dev.entity.Book;
import com.dev.service.IBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Resource
    IBookService iBookService;

    @GetMapping("/hello/{id}")
    public Book hello(@PathVariable("id") int id ){
        Book b = iBookService.getById(id);
        System.out.println(b.toString());
        //return iBookService.getBookNameById(id);
        return b;
    }

    @GetMapping("/hello")
    public void hello(){
        iBookService.transfer();
    }
}
