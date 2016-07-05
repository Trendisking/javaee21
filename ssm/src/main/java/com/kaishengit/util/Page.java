package com.kaishengit.util;

/**
 * Created by 20330 on 2016/7/5.
 */

import java.util.List;

/**
 * Created by 20330 on 2016/6/18.
 */
public class Page<T> {
    /*总记录数*/
    private Integer totalSize;
    /*总页数*/
    private Integer totalPage;
    /*当前页码*/
    private Integer pageNo;
    /*每页数据条数*/
    private Integer pageSize;
    /*当前页面的数据*/
    private List<T> items;
    /*获取当前页面起始条数*/
    private Integer start;

    /**
     *@param pageNo 当前页数
     *@param pageSize 每页显示的数据条数
     *@param totalSize 总记录条数
     */
    public Page(Integer pageNo, Integer pageSize, Integer totalSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        totalPage=totalSize/pageSize;
        if(totalSize % pageSize !=0){
            totalPage++;
        }
        if(pageNo>totalPage){
            this.pageNo=totalPage;
        }
        if(pageNo<=0){
            this.pageNo=1;
        }
        start=(this.pageNo-1)*pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public Integer getStart() {
        return start;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
