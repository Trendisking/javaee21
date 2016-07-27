package com.kaishengit.pojo;

import java.util.Set;

/**
 * Created by 20330 on 2016/7/26.
 */
public class Dept {
    private Integer id;
    private String deptname;
    private Set<Employee> employeeSet;

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", employeeSet=" + employeeSet +
                '}';
    }
}
