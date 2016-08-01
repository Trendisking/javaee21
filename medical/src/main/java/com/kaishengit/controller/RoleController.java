package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @RequestMapping(method = RequestMethod.GET)
    public String roleList(){
        return "role/list";
    }
    @RequestMapping(value="/new",method = RequestMethod.GET)
    public String newRole(){
        return "role/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveRole(){
        return "redirect:/role";
    }
}
