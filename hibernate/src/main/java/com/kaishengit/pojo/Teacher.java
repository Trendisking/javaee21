package com.kaishengit.pojo;

import java.util.Set;

/**
 * Created by 20330 on 2016/7/27.
 */
public class Teacher {
    private Integer id;
    private String teaname;
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
