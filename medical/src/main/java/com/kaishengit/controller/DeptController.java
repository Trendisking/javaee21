package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @RequestMapping(method= RequestMethod.GET)
    public String deptList(){
        return "dept/list";
    }
    @RequestMapping(value="/new",method=RequestMethod.GET)
    public String newDept(){
        return "dept/new";
    }
    @RequestMapping(value="/new",method=RequestMethod.POST)
    public String  saveDept(){
        return "redirect:/dept";
    }
}
