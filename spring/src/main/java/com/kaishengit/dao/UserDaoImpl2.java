package com.kaishengit.dao;

/**
 * Created by 20330 on 2016/6/30.
 */
public class UserDaoImpl2 implements UserDao{

    @Override
    public Integer save() {
        System.out.println("user add");
        return 100;
    }
}
