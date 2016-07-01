package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

/**
 * Created by 20330 on 2016/7/1.
 */
public interface UserMapper {
    void save(User user);
    User findById(Integer id);
}
