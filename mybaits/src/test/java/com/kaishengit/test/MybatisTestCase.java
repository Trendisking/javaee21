package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


/**
 * Created by 20330 on 2016/6/27.
 */
public class MybatisTestCase {
    private Logger logger= LoggerFactory.getLogger(MybatisTestCase.class);
    @Test
    public void testLoadXml(){
        try {
            //从classPath读取mybatis.xml配置文件
            Reader reader= Resources.getResourceAsReader("mybatis.xml");
            //根据SqlSessionFactoryBulider构建SqlSessionFactory
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession=factory.openSession();

            User user=sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);
            logger.debug("{}",user);

            sqlSession.close();
            Assert.assertNotNull(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSave(){
        try {
            Reader reader=Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            User user=new User();
            user.setUsername("吕布");
            user.setPassword("123456");
            user.setAddress("下邳");
            sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        User user=sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",7);
        user.setAddress("河南");
        sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDel(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.mapper.UserMapper.del",6);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testFindAll(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        List<User> userList=sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
       for(User user:userList){
           logger.debug("{}",user);
       }
        sqlSession.close();
        Assert.assertEquals(7,userList.size());
    }
}
