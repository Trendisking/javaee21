package com.kaishengit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/4.
 */
@Controller
public class HomeController {
    private Logger logger= LoggerFactory.getLogger(HomeController.class);
    //localhost/home
    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String home(){
        logger.debug("hello,springmvc");
        return "home";

    }
}
