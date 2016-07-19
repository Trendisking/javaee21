package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 20330 on 2016/7/16.
 */
public class SalesFile implements Serializable {
    private Integer id;
    private Integer salesid;
    private String name;
    private String filename;
    private String contenttype;
    private Timestamp createtime;
    private Long size;

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

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SalesFile{" +
                "id=" + id +
                ", salesid=" + salesid +
                ", name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", createtime=" + createtime +
                ", size=" + size +
                '}';
    }
}
