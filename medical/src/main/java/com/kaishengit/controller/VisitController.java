package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/visit")
public class VisitController {
    @RequestMapping(method= RequestMethod.GET)
    public String visitList(){
        return "visit/list";
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newVisit(){
        return "visit/new";

    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveList(){
        return "redirect:/visit";
    }
}
