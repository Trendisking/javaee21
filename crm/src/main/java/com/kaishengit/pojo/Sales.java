package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 20330 on 2016/7/15.
 */
public class Sales implements Serializable{
    private Integer id;
    private Integer userid;
    private Integer customerid;
    private String name;
    private Float price;
    private String customername;
    private String progress;
    private Timestamp createtime;
    private String lasttime;
    private String successtime;
    private String username;
    private User user;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSuccesstime() {
        return successtime;
    }

    public void setSuccesstime(String successtime) {
        this.successtime = successtime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", userid=" + userid +
                ", customerid=" + customerid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", customername='" + customername + '\'' +
                ", progress='" + progress + '\'' +
                ", createtime=" + createtime +
                ", lasttime='" + lasttime + '\'' +
                ", successtime='" + successtime + '\'' +
                ", username='" + username + '\'' +
                ", user=" + user +
                ", customer=" + customer +
                '}';
    }
}
