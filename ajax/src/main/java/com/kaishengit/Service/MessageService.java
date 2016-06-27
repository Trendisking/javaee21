package com.kaishengit.Service;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;

import java.util.List;

/**
 * Created by 20330 on 2016/6/24.
 */
public class MessageService {
    private MessageDao messageDao=new MessageDao();
    public List<Message> findAll(){
        return messageDao.findAll();
    }

    public List<Message> findMessageByMaxId(String maxId) {
        return MessageDao.findByMaxId(maxId);

    }
}
