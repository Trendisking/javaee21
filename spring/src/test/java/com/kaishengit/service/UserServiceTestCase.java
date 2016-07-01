package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by 20330 on 2016/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserServiceTestCase {
    @Inject
    private UserService userService;
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("mybatis+spring");
        user.setPassword("123");
        user.setAddress("焦作");
        userService.save(user);
    }
    @Test
    public void testFindByUserId(){
        User user=userService.findByUserId(2);
        Assert.assertNotNull(user);

    }


}
