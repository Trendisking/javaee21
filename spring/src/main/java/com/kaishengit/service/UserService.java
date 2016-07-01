package com.kaishengit.service;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 20330 on 2016/7/1.
 */
@Named
@Transactional
public class UserService {
    @Inject
    private UserMapper userMapper;

    public void save(User user){
        userMapper.save(user);
    }
    public User findByUserId(Integer id){
        return userMapper.findById(id);
    }

}

