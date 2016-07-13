package com.kaishengit.mapper;

import com.kaishengit.pojo.Notice;

import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/11.
 */
public interface NoticeMapper {
    void save(Notice notice);

    List<Notice> findByParam(Map<String, Object> param);

    Long count();

    Notice findById(Integer id);
}
