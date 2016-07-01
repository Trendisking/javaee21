package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 20330 on 2016/7/1.
 */
public class LoginLog implements Serializable {
    private Integer id;
    private String ip;
    private Integer userid;
    private Timestamp createtime;

    public LoginLog() {
    }

    public LoginLog(String ip, Integer userid) {
        this.userid = userid;
        this.ip=ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", userid=" + userid +
                ", createtime=" + createtime +
                '}';
    }
}
