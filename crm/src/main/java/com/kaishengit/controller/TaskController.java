package com.kaishengit.controller;

import com.kaishengit.dto.JSONResult;
import com.kaishengit.pojo.Task;
import com.kaishengit.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/18.
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Inject
    private TaskService taskService;
    @RequestMapping(method = RequestMethod.GET)
    public String list(){
        return "task/list";

    }
    @RequestMapping(value="/load",method=RequestMethod.GET)
    @ResponseBody
    public List<Task> load(String start, String end){
        return taskService.findTaskByUserId(start,end);
    }
    @RequestMapping(value="/new",method =RequestMethod.POST )
    @ResponseBody
    public JSONResult save(Task task,String hour,String min){
        taskService.saveTask(task,hour,min);
        return new JSONResult(task);

    }
}
