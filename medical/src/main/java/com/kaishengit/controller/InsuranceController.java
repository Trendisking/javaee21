package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    @RequestMapping(method = RequestMethod.GET)
    public String insuranceList(){
        return "insurance/list";
    }
    @RequestMapping(value="/new",method = RequestMethod.GET)
    public String newInsurance(){
      return "insurance/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveInsurance(){
       return "redirect:/insurance";
    }
}
