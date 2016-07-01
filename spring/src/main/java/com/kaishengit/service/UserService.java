package com.kaishengit.service;

import com.kaishengit.dao.LoginLogDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.LoginLog;
import com.kaishengit.pojo.User;
import org.springframework.transaction.annotation.Isolation;
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
    private UserDao userDao;
    @Inject
    private LoginLogDao loginLogDao;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User findByUserId(Integer userid){
        return userDao.findById(userid);
    }
    @Transactional
    public User login(String username,String password,String ip)  {
        User user=userDao.findByUserName(username);
        if(user!=null&&user.getPassword().equals(password)){
            loginLogDao.save(new LoginLog(ip,user.getId()));

            return user;
        }else{
            throw new ServiceException("账号或密码错误");
        }

    }
}

