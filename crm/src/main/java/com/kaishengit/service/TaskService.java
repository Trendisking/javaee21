package com.kaishengit.service;

import com.kaishengit.mapper.TaskMapper;
import com.kaishengit.pojo.Task;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by 20330 on 2016/7/18.
 */
@Named
public class TaskService {

    @Inject
    private TaskMapper taskMapper;
    private Logger logger= LoggerFactory.getLogger(TaskService.class);
    public List<Task> findTaskByUserId(String start, String end) {
        return taskMapper.findByUserIdAndDateRanger(ShiroUtil.getCurrentUserID(),start,end);
    }

    public void saveTask(Task task, String hour, String min) {
        if(StringUtils.isNotEmpty(hour)&&StringUtils.isNotEmpty(min)){
            String reminderTime = task.getStart() + " "+hour + ":" + min + ":00";
            logger.debug("提醒时间为{}" , reminderTime);
            //TODO Quartz动态任务
            task.setRemindertime(reminderTime);
        }
        task.setUserid(ShiroUtil.getCurrentUserID());
        taskMapper.save(task);
    }
}
