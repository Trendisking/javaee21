package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by 20330 on 2016/7/30.
 */
@Entity
@Table(name="t_insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
