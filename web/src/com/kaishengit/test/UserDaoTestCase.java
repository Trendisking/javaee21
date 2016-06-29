package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by 20330 on 2016/6/12.
 */
public class UserDaoTestCase {
    private UserDao userdao=new UserDao();



    @Test
    public void testSave(){
        User user=new User("刘洁","000","日本");
        userdao.save(user);


    }
    @Test
    public void testDel(){
        userdao.del(3);
    }
    @Test
    public void testFindById(){
        User user=userdao.findById(2);
        Assert.assertNotNull(user);
        System.out.println(user);

    }
    @Test
     public void testFindAll(){
        List<User> userList=userdao.findAll();
        Assert.assertEquals(userList.size(),1);
   }
}
