package com.kaishengit.mapper;

import com.kaishengit.pojo.Node;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 20330 on 2016/6/28.
 */
public interface NodeMapper {
    void batchSave(List<Node> nodeList);
    List<Node> findByIds(List<Integer> idList);
    @Select("select * from t_node where id=#{id}")
    Node findById(Integer id);
}
