package com.kaishengit.test;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.pojo.Person;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 20330 on 2016/7/26.
 */
public class OneToManyTestCase {
    /*
    * 1.最佳实践：先存一，再存多
    * 2.让一的一端放弃关系维护
    * 3.fetch="join" 可以避免N+1问题
    * */
    @Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept=new Dept();
        dept.setDeptname("听潮亭");

        Employee employee=new Employee();
        employee.setEmpname("桃花");
        employee.setDept(dept);

        Employee employee1=new Employee();
        employee1.setEmpname("紫衣");
        employee1.setDept(dept);

        Set<Employee> employees=new HashSet<Employee>();
        employees.add(employee);
        employees.add(employee1);
        dept.setEmployeeSet(employees);

        session.save(dept);
        session.save(employee);
        session.save(employee1);


        session.getTransaction().commit();

    }
    @Test
    public void testFindDept(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept=(Dept)session.get(Dept.class,19);
        //System.out.println(dept);
        System.out.println(dept.getDeptname());
        Set<Employee> employeeSet=dept.getEmployeeSet();
        for(Employee employee:employeeSet){
            System.out.println(employee.getEmpname());
        }
        session.getTransaction().commit();

    }
    @Test
    public void testFindEmployee(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Employee employee=(Employee)session.get(Employee.class,30);
        System.out.println(employee.getEmpname());
        Dept dept=employee.getDept();
        System.out.println(dept.getDeptname());
        session.getTransaction().commit();

    }

    @Test
    public void testFindEmployeeAll(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        //N+1 fetch="join"
        Criteria criteria=session.createCriteria(Employee.class);
        List<Employee> employeeList=criteria.list();
        for(Employee employee:employeeList){
            System.out.println(employee.getId()+":"+employee.getEmpname()+":"+employee.getDept().getDeptname());
        }
        session.getTransaction().commit();

    }
    @Test
    public void testDelCard(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept=(Dept) session.get(Dept.class,15);
        session.delete(dept);
        session.getTransaction().commit();
    }
    @Test
    public void testDelPerson(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Person person=(Person) session.get(Person.class,10);
        session.delete(person);
        session.getTransaction().commit();

    }
}
