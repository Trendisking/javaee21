package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/chart")
public class ChartController {
    @RequestMapping(method= RequestMethod.GET)
    public String chartList(){
        return "chart/home";
    }
}
