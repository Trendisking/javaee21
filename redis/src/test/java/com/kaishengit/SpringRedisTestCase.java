package com.kaishengit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 20330 on 2016/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringRedisTestCase {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testSet(){
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set("spring_data","springspring");

    }
    @Test
    public void testGet(){
        System.out.println(redisTemplate.opsForValue().get("spring_data"));

    }
    @Test
    public void testIncr(){
        redisTemplate.opsForValue().increment("post:1:viewnum",1);
        System.out.println(redisTemplate.opsForValue().get("post:1:viewnum"));

    }
}
