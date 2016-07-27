package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by 20330 on 2016/7/26.
 */
@Entity
@Table(name = "t_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empname;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptid")//指定外键
    private Dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


}
