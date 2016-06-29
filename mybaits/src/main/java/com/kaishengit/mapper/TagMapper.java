package com.kaishengit.mapper;

import com.kaishengit.pojo.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 20330 on 2016/6/29.
 */
public interface TagMapper {
    @Select("select * from t_tag where userId=#{userId}")

    List<Tag> findByUserId(Integer userId);
}
