package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by 20330 on 2016/7/25.
 */
public class CriteriaTestCase {
    @Test
    public void testFindAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();
        for (User user : userList) {
            System.out.println(user);
        }

        session.getTransaction().commit();

    }

    @Test
    public void testFindByWhere() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        //criteria.add(Restrictions.eq("password","1234"));
        //criteria.add(Restrictions.eq("username","pose"));
        //criteria.add(Restrictions.or(Restrictions.eq("username","pose"),Restrictions.eq("username","张良")));
        //!!!!!! or
        /*Disjunction disjunction= Restrictions.disjunction();
        disjunction.add(Restrictions.eq("username","pose"));
        disjunction.add(Restrictions.eq("username","张良"));
        criteria.add(disjunction);*/

        //criteria.add(Restrictions.in("username",new Object[]{"pose","张良"}));

        //LIKE !!!
        criteria.add(Restrictions.like("username", "o", MatchMode.ANYWHERE));
        List<User> userList = criteria.list();
        for (User user : userList) {
            System.out.println(user);
        }

        session.getTransaction().commit();

    }
    @Test
    public void testUnique(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username","1234"));
        User user=(User)criteria.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();

    }
    @Test
    public void testByPage(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));//排序
        criteria.setMaxResults(5);//分页
        criteria.setFirstResult(0);
        List<User> userList=criteria.list();
        for(User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();

    }
    @Test
    public void testCount(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
        //criteria.setProjection(Projections.rowCount());
        //criteria.setProjection(Projections.max("id"));
        ProjectionList projectionList=Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));
        criteria.setProjection(projectionList);

        Object[] objects=(Object[])criteria.uniqueResult();

        System.out.println("Count:"+objects[0]);
        System.out.println("Max:"+objects[1]);
        session.getTransaction().commit();

    }
}
