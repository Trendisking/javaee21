package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    @RequestMapping(method = RequestMethod.GET)
    public String patientList(){
        return "patient/list";
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newPatient(){
        return "patient/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String savePatient(){
        return "redirect:/patient";
    }


}
