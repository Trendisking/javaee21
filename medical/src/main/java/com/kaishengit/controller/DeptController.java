package com.kaishengit.controller;

import com.kaishengit.Service.DeptService;
import com.kaishengit.pojo.Dept;
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
@RequestMapping("/dept")
public class DeptController {
    @Inject
    private DeptService deptService;
    @RequestMapping(method= RequestMethod.GET)
    public String deptList(Model model){
        List<Dept> deptList=deptService.findAllDept();
        model.addAttribute("deptList",deptList);
        return "dept/list";
    }
    @RequestMapping(value="/new",method=RequestMethod.GET)
    public String newDept(){
        return "dept/new";
    }

    @RequestMapping(value="/new",method=RequestMethod.POST)
    public String  saveDept(Dept dept){
        deptService.saveDept(dept);

        return "redirect:/dept";
    }
    @RequestMapping(value="/{id:\\d+}/del",method = RequestMethod.GET)
    public String delDept(@PathVariable Integer id){
        deptService.delDept(id);
        return "redirect:/dept";
    }
    @RequestMapping(value="/{id:\\d+}/edit",method = RequestMethod.GET)
    public String editDept(@PathVariable Integer id,Model model){
        Dept dept=deptService.findDeptById(id);
        model.addAttribute("dept",dept);
       return "dept/edit";
    }
    @RequestMapping(value = "/{id:\\d+}/edit",method=RequestMethod.POST)
    public String editDept(Dept dept){
        deptService.saveDept(dept);
        return "redirect:/dept";
    }
}
