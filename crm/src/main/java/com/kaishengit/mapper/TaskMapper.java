package com.kaishengit.mapper;

import com.kaishengit.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 20330 on 2016/7/18.
 */
public interface TaskMapper {

    List<Task> findByUserIdAndDateRanger(@Param("userid") Integer currentUserID, @Param("start")String start, @Param("end")String end);

    void save(Task task);

    List<Task> findTimeOutTask(@Param("userId") Integer userID,@Param("today") String today);

    void del(Integer id);

    Task findById(Integer id);

    void update(Task task);

    List<Task> findAll();
}
