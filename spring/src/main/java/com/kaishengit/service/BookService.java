package com.kaishengit.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by 20330 on 2016/6/30.
 */
public class BookService {
    private String bookName;
    private Integer num;
    private List<String> lists;
    private Map<String,Object> maps;
    private Set<String> sets;
    private Properties properties;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public void showBook() {
        System.out.println("BookService{" +
                "bookName='" + bookName + '\'' +
                ", num=" + num +
                ", lists=" + lists +
                ", maps=" + maps +
                ", sets=" + sets +
                ", properties=" + properties +
                '}');
    }
}
