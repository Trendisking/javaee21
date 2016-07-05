package com.kaishengit.mapper;

import com.kaishengit.pojo.Book;

import java.util.List;

/**
 * Created by 20330 on 2016/7/5.
 */
public interface BookMapper {
    void save(Book book);
    List<Book> findAll();
    void del(Integer id);
    void update(Book book);
    Book findById(Integer id);


}
