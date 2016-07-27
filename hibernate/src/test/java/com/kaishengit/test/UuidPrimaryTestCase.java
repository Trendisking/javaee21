package com.kaishengit.test;

import com.kaishengit.pojo.Task;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 20330 on 2016/7/27.
 */
public class UuidPrimaryTestCase {
    @Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Task task=new Task();
        task.setTitle("X-MAN");
        session.save(task);
        session.getTransaction().commit();

    }
    @Test
    public void testFindById(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Task task=(Task)session.get(Task.class,"4028819a562acadc01562acae14b0000");
        //System.out.println(session.contains(task));
        //session.clear();将持久态纳入游离态，并将清除一级缓存
       // session.evict(task);//将指定的对象从一级缓存中清除
        //Task task1=(Task)session.get(Task.class,"4028819a562acadc01562acae14b0000");
        //System.out.println(task1.getTitle());
        session.getTransaction().commit();
        //将对象从二级缓存中清除
        Cache cache=HibernateUtil.getSessionFactory().getCache();
        cache.evictEntityRegion(Task.class);

        Session session1=HibernateUtil.getSession();
        session1.beginTransaction();
        Task task2=(Task)session1.get(Task.class,"4028819a562acadc01562acae14b0000");
        System.out.println(task2.getTitle());
        session1.getTransaction().commit();


    }
}
