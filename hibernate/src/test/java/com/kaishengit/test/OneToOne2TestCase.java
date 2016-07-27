package com.kaishengit.test;

import com.kaishengit.pojo.Topic;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 20330 on 2016/7/27.
 */
public class OneToOne2TestCase {
   @Test
    public void  testFind(){
       Session session= HibernateUtil.getSession();
       session.beginTransaction();
       Topic topic=(Topic)session.get(Topic.class,1);
       System.out.println(topic);
       System.out.println(topic.getTopicContent().getContent());
       session.getTransaction().commit();

    }
}
