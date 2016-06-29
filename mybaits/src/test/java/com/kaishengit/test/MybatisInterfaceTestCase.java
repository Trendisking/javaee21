package com.kaishengit.test;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Tag;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/6/28.
 */
public class MybatisInterfaceTestCase {
    private Logger logger= LoggerFactory.getLogger(MybatisInterfaceTestCase.class);
    @Test
    public void testFindByPage(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.findByPage(0,2);
        for(User user:userList){
            logger.debug("{}",user);
        }
        sqlSession.close();

    }

    @Test
    public void testFindByQueryParam(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> queryParam=Maps.newHashMap();
        //queryParam.put("username","张三");
        //queryParam.put("email","456@126.com");
        queryParam.put("password","000");
        userMapper.findByQueryParam(queryParam);
        sqlSession.close();


    }
    @Test
    public void testFindByParams(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findByParams("张三","000");
        logger.debug("{}",user);
        Assert.assertNotNull(user);



    }


    @Test
    public void testFindByMap(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> param= Maps.newHashMap();
        param.put("username","张三");
        param.put("password","000");
        User user=userMapper.findByMap(param);
        logger.debug("{}",user);
        Assert.assertNotNull(user);
    }





    @Test
    public void testFindById(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findById(10);
        logger.debug("{}",user);
        List<Tag> tagList=user.getTagList();
        for(Tag tag:tagList){
            logger.debug("{}",tag);
        }
        sqlSession.close();
        Assert.assertNotNull(user);
    }
    @Test
    public void testSave(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("吕小布");
        user.setPassword("123456");
        user.setAddress("下邳");
        userMapper.save(user);
        logger.debug("UserId:{}",user.getId());
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findById(10);
        user.setAddress("凉州");
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDel(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        userMapper.del(9);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testFindAll(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.findAll();
        for(User user:userList){
            logger.debug("{}",user);
        }
        sqlSession.close();

    }
}
