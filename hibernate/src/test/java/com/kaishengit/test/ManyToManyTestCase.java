package com.kaishengit.test;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 20330 on 2016/7/27.
 */
public class ManyToManyTestCase {
    @Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher=new Teacher();
        teacher.setTeaname("T");
        Teacher teacher1=new Teacher();
        teacher1.setTeaname("T1");

        Student student=new Student();
        student.setStuname("张良");

        Student student1=new Student();
        student1.setStuname("韩信");

        Set<Teacher> teacherSet=new HashSet<Teacher>();
        teacherSet.add(teacher);
        teacherSet.add(teacher1);

        student.setTeacherSet(teacherSet);
        student1.setTeacherSet(teacherSet);

        /*Set<Student> studentSet=new HashSet<Student>();
        studentSet.add(student);
        studentSet.add(student1);

        teacher.setStudentSet(studentSet);
        teacher1.setStudentSet(studentSet);*/

        session.save(teacher);
        session.save(teacher1);
        session.save(student);
        session.save(student1);

        session.getTransaction().commit();

    }
    @Test
    public void testFindTeacher(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher=(Teacher) session.get(Teacher.class,19);
        System.out.println(teacher.getTeaname());

        Set<Student> studentSet=teacher.getStudentSet();
        for(Student student:studentSet){
            System.out.println(student.getId()+":"+student.getStuname());
        }
        session.getTransaction().commit();
    }
}
