package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 20330 on 2016/6/14.
 */
public class UserServiceTestCase {
    private UserService userService=new UserService();
    @Test
    public void testLogin(){
        User user =userService.login("张三","000");
        Assert.assertNotNull(user);

    }
}
