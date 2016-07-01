package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")

public class UserDaoTestCase {
    @Inject
    private UserDao userDao;
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("郭嘉");
        user.setPassword("鬼才");
        user.setAddress("三国");
        userDao.save(user);
    }
    @Test
    public void testFindById(){
        User user=userDao.findById(10);
        System.out.println(user);
        Assert.assertNotNull(user);

    }
    @Test
    public void testFindByUserName(){
        User user =userDao.findByUserName("郭嘉");
        System.out.println(user);
        Assert.assertNotNull(user);
    }
    @Test
    public void testFindAll(){
        List<User>  userList=userDao.findAll();
        Assert.assertEquals(userList.size(),11);
        for(User user :userList){
            System.out.println(user);
        }
    }
    @Test
    public void testCount(){
        Long count=userDao.count();
        Assert.assertEquals(count.intValue(),11);

    }
}
