package com.dev.service;

import com.dev.entity.Book;

public interface IBookService {

    Book getById(Integer id);

    void transfer();
}
