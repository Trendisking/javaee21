package com.kaishengit.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 20330 on 2016/7/27.
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teaname;
    @ManyToMany(mappedBy = "teacherSet")
    @OrderBy("id asc ")
    private Set<Student> studentSet;

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }
}
