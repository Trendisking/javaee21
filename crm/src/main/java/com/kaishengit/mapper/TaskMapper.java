package com.kaishengit.mapper;

import com.kaishengit.pojo.Task;

import java.util.List;

/**
 * Created by 20330 on 2016/7/18.
 */
public interface TaskMapper {

    List<Task> findByUserIdAndDateRanger(Integer currentUserID, String start, String end);

    void save(Task task);
}
