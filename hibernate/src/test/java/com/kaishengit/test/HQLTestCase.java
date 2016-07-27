package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by 20330 on 2016/7/25.
 */
public class HQLTestCase {
    @Test
    public void testFindAll(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User";
        Query query=session.createQuery(hql);
        List<User> userList=query.list();
        for(User user:userList){
            System.out.println(user);
        }

        session.getTransaction().commit();

    }

    @Test
    public void testFindByWhere(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User where password=:password and username=:name";
        Query query=session.createQuery(hql);
       // query.setString(0,"1234");
        //query.setParameter(0,"1234");
       // query.setString("password","1234");
        query.setParameter("password","1234");
        query.setParameter("name","rose");
        List<User> userList=query.list();
        for(User user:userList){
            System.out.println(user);
        }

        session.getTransaction().commit();

    }
    @Test
    public void testFindUtil(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        String hql="from User where password=:pwd";
        Query query=session.createQuery(hql);
        query.setParameter("pwd","3456789");
        User user=(User)query.uniqueResult();
        System.out.print(user);

        session.getTransaction().commit();

    }
    @Test
    public void testFindByColumn(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        String hql="select id,username from User";
        Query query=session.createQuery(hql);
        List<Object[]> result=query.list();
        for(Object[] objects:result){
            System.out.println(objects[0]+"-->"+objects[1]);
        }
       /* List<String> result =query.list();
        for(String name:result){
            System.out.println(name);
        }*/
        session.getTransaction().commit();


    }
    @Test
    public void testCount(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        String hql="select count(*),max(id)from User";
        Query query=session.createQuery(hql);
        Object[] objects=(Object[]) query.uniqueResult();
        System.out.println("Count:"+objects[0]);
        System.out.println("MAX:"+objects[1]);

        session.getTransaction().commit();

    }
    @Test
    public void testPage(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User order by id desc";
        Query query=session.createQuery(hql);
        query.setFirstResult(3);
        query.setMaxResults(3);
        List<User> userList=query.list();
        for(User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();


    }
}
