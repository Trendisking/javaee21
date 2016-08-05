package com.kaishengit.controller;

import com.kaishengit.Service.InsuranceService;
import com.kaishengit.pojo.Insurance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    @Inject
    private InsuranceService insuranceService;
    @RequestMapping(method = RequestMethod.GET)
    public String insuranceList(Model model){
        List<Insurance> insuranceList=insuranceService.findAllInsurance();
        model.addAttribute("insuranceList",insuranceList);
        return "insurance/list";
    }
    @RequestMapping(value="/new",method = RequestMethod.GET)
    public String newInsurance(){
      return "insurance/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveInsurance(Insurance insurance){
        insuranceService.saveInsurance(insurance);
       return "redirect:/insurance";
    }
    @RequestMapping(value = "/{id:\\d+}/del",method=RequestMethod.GET)
    public String delInsurance(@PathVariable Integer id){
        insuranceService.delInsurance(id);
        return "redirect:/insurance";
    }
    @RequestMapping(value="/{id:\\d+}/edit",method=RequestMethod.GET)
    public String editInsurance(@PathVariable Integer id,Model model){
        Insurance insurance=insuranceService.findInsuranceById(id);
        model.addAttribute("insurance",insurance);
        return "insurance/edit";
    }
    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.POST)
    public String editInsurance(Insurance insurance){
        insuranceService.saveInsurance(insurance);
        return "redirect:/insurance";
    }
}
