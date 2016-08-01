package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/notify")
public class NotifyController {
    @RequestMapping(method= RequestMethod.GET)
    public String notifyList(){
        return "notify/list";
    }
}
