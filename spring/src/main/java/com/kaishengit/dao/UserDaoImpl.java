package com.kaishengit.dao;

/**
 * Created by 20330 on 2016/6/30.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public Integer save() {
        System.out.println("userDao save");

        if(1==1){
            throw new RuntimeException("大事不好了!");
        }
        return 10000;
    }
}
