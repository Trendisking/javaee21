package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 20330 on 2016/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTestCase {
    @Autowired
    private UserService userService;
    @Test
    public void testFind(){
        User user=userService.findUserById(102);
        System.out.println(user);

    }
    @Test
    public void testSave(){
        User user=new User(102,"lisi",8555.6F);
        userService.saveUser(user);

    }
}
