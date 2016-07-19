package com.kaishengit.mapper;

import com.kaishengit.pojo.SalesFile;

import java.util.List;

/**
 * Created by 20330 on 2016/7/16.
 */

public interface SalesFileMapper {
    void save(SalesFile salesFile);

    List<SalesFile> findBySalesId(Integer salseid);

    SalesFile findById(Integer id);

    void del(List<SalesFile> salesFileList);
}
