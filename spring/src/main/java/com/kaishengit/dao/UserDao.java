package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by 20330 on 2016/7/1.
 */
public interface UserDao {
    void save(User user);
    void del(Integer id);
    void update(User user);
    User findById(Integer id);
    List<User> findAll();
    User findByUserName(String username);
    Long count();
}
