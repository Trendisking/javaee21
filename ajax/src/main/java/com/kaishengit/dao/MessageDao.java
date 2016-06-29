package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.cache.EhcacheUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 20330 on 2016/6/24.
 */
public class MessageDao {
    private Logger logger= LoggerFactory.getLogger(MessageDao.class);

    public Message findById(Integer id){
        Message message=(Message) EhcacheUtil.get("message:"+id);
        if(message==null){
            String sql="select * from t_message where id=?";
            message= DbHelp.query(sql,new BeanHandler<Message>(Message.class),id);
            EhcacheUtil.set("message:"+id,message);
        }else{
            logger.debug("load message from cache");
        }
        return message;
    }

    public List<Message> findAll(){
        List<Message> messageList=(List<Message>) EhcacheUtil.get("messageList");
        if(messageList==null){
            String sql="select * from t_message order by id desc";
            messageList=DbHelp.query(sql,new BeanListHandler<>(Message.class));
            EhcacheUtil.set("messageList",messageList);
        }
        return messageList;
    }

    public void save(Message message){
        String sql="insert into t_message(message author) values(?,?)";
        DbHelp.update(sql,message.getMessage(),message.getAuthor());
        EhcacheUtil.remove("messageList");
    }

    public static List<Message> findByMaxId(String maxId) {
        String sql="select * from t_message where id > ? order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class),maxId);
    }
}
