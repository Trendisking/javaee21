package com.kaishengit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by 20330 on 2016/8/2.
 */
public class UserDaoTestCase {
    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Test
    public void testFindByUsername(){


    }
}
