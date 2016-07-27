package com.kaishengit.pojo;

import java.util.Set;

/**
 * Created by 20330 on 2016/7/27.
 */
public class Student {
    private Integer id;
    private String stuname;
    private Set<Teacher> teacherSet;

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
}
