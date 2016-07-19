package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 20330 on 2016/7/16.
 */
public class SalesLog implements Serializable {

    public static final String LOG_TYPE_AUTO = "auto";
    public static final String LOG_TYPE_INPUT = "input";

    private Integer id;
    private String context;
    private Timestamp createtime;
    private String type;
    private Integer salesid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    @Override
    public String toString() {
        return "SalesLog{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", createtime=" + createtime +
                ", type='" + type + '\'' +
                ", salesid=" + salesid +
                '}';
    }
}
