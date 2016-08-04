package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.inject.Named;

/**public com.kaishengit.pojo.User findByUsername(String ) {
    }
 * Created by 20330 on 2016/7/31.
 */
@Named
public class UserDao extends BaseDao<User,Integer> {
    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    public User findByUsername(String username) {

        Criteria   criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        User user=(User) criteria.uniqueResult();
        return user;

    }
}
