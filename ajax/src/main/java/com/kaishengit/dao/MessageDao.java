package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by 20330 on 2016/6/24.
 */
public class MessageDao {
    public List<Message> findAll(){
        String sql="select * from t_message order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class));
    }

    public static List<Message> findByMaxId(String maxId) {
        String sql="select * from t_message where id > ? order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class),maxId);
    }
}
