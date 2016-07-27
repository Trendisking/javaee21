package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 20330 on 2016/7/25.
 */
public class HibernateLifeTestCase {
    @Test
    public void tetSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        User user=new User();
        user.setUsername("pose");
        user.setPassword("1234");
        //Integer id=(Integer)session.save(user);
        //System.out.println(id);
        //session.save(user);
        //System.out.println(user.getId());
        session.persist(user);
        System.out.println(user.getId());
        session.getTransaction().commit();

    }
    @Test
    public void testFindByGet(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,1);
        session.getTransaction().commit();

    }

    @Test
    public void testFindByLoad(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=(User)session.load(User.class,1);
        System.out.println(user.getUsername());
        session.getTransaction().commit();

    }
    @Test
    public void testUpdate(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,3);
        session.getTransaction().commit();
        user.setUsername("kuke");
        Session session1=HibernateUtil.getSession();
        session1.beginTransaction();
        session1.update(user);
        session1.getTransaction().commit();

    }
    @Test
    public void testSaveOrUpdate(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=new User();
        user.setUsername("张良");
        user.setPassword("sdsgaeg");
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        user.setPassword("56555");
        Session session1=HibernateUtil.getSession();
        session1.beginTransaction();
        session1.saveOrUpdate(user);
        session1.getTransaction().commit();
    }

    @Test
    public void testMerge(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
       /* User user=new User();
        user.setUsername("张良");
        user.setPassword("sdsgaeg");
        session.merge(user);*/
        User user=(User)session.get(User.class,8);
        session.getTransaction().commit();

            user.setPassword("56555");
            Session session1=HibernateUtil.getSession();
            session1.beginTransaction();
            session1.merge(user);
            session1.getTransaction().commit();
    }
    @Test
    public void testDel(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,9);
        session.delete(user);
        session.getTransaction().commit();
    }
    @Test
    public void testClear(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,8);
        session.clear();
        user.setPassword("5688990");
        session.getTransaction().commit();

    }
}
