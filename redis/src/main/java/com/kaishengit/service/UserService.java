package com.kaishengit.service;

import com.google.gson.Gson;
import com.kaishengit.pojo.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by 20330 on 2016/7/23.
 */
@Service
public class UserService {
    @Autowired
    private JedisPool jedisPool;
    public Jedis getJedis(){
        return jedisPool.getResource();
    }
    public User findUserById(Integer userId){

        try(Jedis jedis=getJedis()){
            byte[] bytes=jedis.get(KeyUtil.userKey(userId).getBytes());
            Schema<User> userSchema=RuntimeSchema.createForm(User.class);
            User user=new User();
            ProtostuffIOUtil.mergeForm(bytes,user,userSchema);
            jedis.close();
            return user;

        }





       /** Jedis jedis=getJedis();

        String json=jedis.get(KeyUtil.userKey(userId));
        User user=new Gson().fromJson(json,User.class);
        if(user==null){

        }
        jedis.close();
        return null;**/
    }

    public void saveUser(User user){
        Schema<User> userSchema=RuntimeSchema.getSchema(User.class);
        byte[] bytes=ProtostuffIOUtil.toByteArray(user,userSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

        try(Jedis jedis = getJedis()) {
            jedis.set(KeyUtil.userKey(user.getId()).getBytes(), bytes);
        }
    }







    /*private RedisTemplate<String,User> redisTemplate;
    @Autowired
    public UserService(RedisTemplate<String,User> redisTemplate){
        this.redisTemplate=redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    public User findUserById(Integer userId){
        User user =redisTemplate.opsForValue().get(KeyUtil.userKey(userId));
        if(user==null){

        }
        return null;
    }*/
}
