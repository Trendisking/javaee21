package com.kaishengit.action;

import com.kaishengit.pojo.User;

/**
 * Created by 20330 on 2016/8/3.
 */
public class JSONAction extends BaseAction {

    private Integer id;
    private String name;
    private User user;
    @Override
    public String execute() throws Exception{
        id=101;
        name="javk";
        user=new User();
        user.setUsername("lisi");
        user.setAddress("河南省");
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
