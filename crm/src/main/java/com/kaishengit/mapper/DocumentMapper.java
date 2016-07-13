package com.kaishengit.mapper;

import com.kaishengit.pojo.Document;

import java.util.List;

/**
 * Created by 20330 on 2016/7/13.
 */
public interface DocumentMapper {

    void save(Document document);
    List<Document> findByFid(Integer fid);
    Document findById(Integer id);
    void del(Integer id);
}
