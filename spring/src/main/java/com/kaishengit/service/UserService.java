package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

/**
 * Created by 20330 on 2016/6/30.
 */
public class UserService {
    private UserDao userDao;

   /* public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/
    public UserService(UserDao userDao){
        this.userDao=userDao;
    }
    public void sayHi(){

        userDao.save();
    }
}
