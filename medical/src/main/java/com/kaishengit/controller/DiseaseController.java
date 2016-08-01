package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/disease")
public class DiseaseController {
    @RequestMapping(method = RequestMethod.GET)
    public String diseaseList(){
        return "disease/list";
    }
    @RequestMapping("/new")
    public String newDisease(){
        return "disease/new";
    }
    @RequestMapping(value = "/new",method=RequestMethod.POST)
    public String saveDisease(){
        return "redirect:/disease";
    }
}
