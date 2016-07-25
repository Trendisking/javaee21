package com.kaishengit;

import com.google.gson.Gson;
import com.kaishengit.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 20330 on 2016/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StringRedisTemplateTestCase {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testSave(){
        stringRedisTemplate.opsForValue().set("user:1","rose");
    }
    @Test
    public void testSaveSet(){
        stringRedisTemplate.opsForSet().add("user:vote","zhangsan","lisi","wangwu");
    }
    @Test
    public void testGetFormSet(){
        Set<String> votes=stringRedisTemplate.opsForSet().members("user:vote");
        for(String  vote:votes){
            System.out.println(vote);

        }
    }
    @Test
    public void testSaveHash(){
        //stringRedisTemplate.opsForHash().put("student:1","name","jack");
        Map<String,String> map=new HashMap<String,String>();
        map.put("address","china");
        map.put("age","23");
        stringRedisTemplate.opsForHash().putAll("student:1",map);
    }
    @Test
    public void testSaveUser(){
        User user =new User(100,"Rose",900.9F);
        stringRedisTemplate.opsForValue().set("user:100",new Gson().toJson(user));
    }
    @Test
    public void testGetUser(){
        String json=stringRedisTemplate.opsForValue().get("user:100");
       User user=new Gson().fromJson(json,User.class);
        System.out.println(user);


    }

}
