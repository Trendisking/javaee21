package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/8.
 */
public interface UserMapper {
    User findByUsername(String username);


    void updateUser(User user);

    List<User> findByParam(Map<String, Object> params);

    Long count();

    Long countByParam(Map<String, Object> params);
}
