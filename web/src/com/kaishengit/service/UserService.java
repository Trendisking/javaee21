package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import com.kaishengit.util.EmailUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 20330 on 2016/6/14.
 */


public class UserService {
    private final String SALT="gheirgoegnfdoiaer";
    private Logger logger= LoggerFactory.getLogger(UserService.class);
    private UserDao userDao=new UserDao();
    /**
     *用户登录
     * @param username 账号
     * @param password 密码
     * @return 如果成功登陆返回User对象,登陆失败返回null
     */
    public User login(final String username,String password){
        final User user=userDao.findByUsername(username);
        if(user!=null&&user.getPassword().equals((password ))){
            logger.debug("{}登陆成功",username);

            Thread thread=new Thread(new Runnable(){

                @Override
                public void run() {
                    EmailUtil.sendHtmlEmail(user.getAddress(),"账号登陆提示","你的账号"+username+"在"+DateTime.now().toString("yyyy-MM-dd HH:mm:ss")+"登陆了系统");
                }
            });
        }
        return null;
    }
}
