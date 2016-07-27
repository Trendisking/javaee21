package com.kaishengit.test;

import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 20330 on 2016/7/26.
 */
public class OneToOneTestCase {
   @Test
    public void testSave(){
       Session session= HibernateUtil.getSession();
       session.beginTransaction();

       Person person=new Person();
       person.setName("洛阳");

       Card card=new Card();
       card.setCardname("VIP2");
       card.setPerson(person);
       session.save(card);
       session.save(person);


       session.getTransaction().commit();

    }
    @Test
    public void testFindPerson(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Person person=(Person) session.get(Person.class,10);
        System.out.println(person.getName());
        System.out.println(person.getCard().getCardname());
        session.getTransaction().commit();

    }
    @Test
    public void testFindByCard(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Card card=(Card) session.get(Card.class,10);
        System.out.println(card.getCardname());
        System.out.println(card.getPerson().getName());

        session.getTransaction().commit();

    }
    @Test
    public void testDeleteCard(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Card card=(Card)session.get(Card.class,11);
        session.delete(card);
        session.getTransaction().commit();

    }
}
