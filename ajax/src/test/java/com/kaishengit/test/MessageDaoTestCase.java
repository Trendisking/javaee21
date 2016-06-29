package com.kaishengit.test;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by 20330 on 2016/6/27.
 */
public class MessageDaoTestCase {

    private MessageDao messageDao=new MessageDao();
    @Test
    public void testFindById(){

        Message message=messageDao.findById(1);
        message=messageDao.findById(1);
        Assert.assertNotNull(message);

    }
    @Test
    public void testFindAll(){
        List<Message> messageList=messageDao.findAll();
        messageList=messageDao.findAll();
        Message message=new Message();

        message.setMessage("message24");
        message.setAuthor("tom");
        messageDao.save(message);
        messageList=messageDao.findAll();
        messageList=messageDao.findAll();
        Assert.assertEquals(28,messageList.size());
    }



    @Test
    public void testOne(){
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

    @Test
    public void testEhcache(){
        CacheManager cacheManager=new CacheManager();
        Ehcache ehcache=cacheManager.getEhcache("mycache");
        //向缓存中存值
        Element element=new Element("user:1","java");
        ehcache.put(element);
        //将ehcache中的值删除
        ehcache.remove("user:1");
        //从缓存中取值
        Element outelement=ehcache.get("user:1");
        String value=null;
        if(outelement!=null){
            value=(String)outelement.getObjectValue();
            System.out.println(value);

        }
        Assert.assertNotNull(value);
    }


}
