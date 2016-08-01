package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/account")
public class accountController {
    @RequestMapping(method= RequestMethod.GET)
    public String accountList(){
        return "account/list";
    }
    @RequestMapping(value="/new",method=RequestMethod.GET)
    public String newAccount(){
        return "account/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveAccount(){
        return "redirect:/account";
    }
}
