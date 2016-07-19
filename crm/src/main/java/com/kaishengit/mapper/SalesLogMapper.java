package com.kaishengit.mapper;

import com.kaishengit.pojo.SalesLog;

import java.util.List;

/**
 * Created by 20330 on 2016/7/16.
 */

public interface SalesLogMapper {
    void save(SalesLog salesLog);

    List<SalesLog> findBySalesId(Integer salesid);

    void del(List<SalesLog> salesLogList);
}
