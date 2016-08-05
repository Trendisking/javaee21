package com.kaishengit.controller;

import com.kaishengit.Service.RoleService;
import com.kaishengit.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Inject
    private RoleService roleService;
    @RequestMapping(method = RequestMethod.GET)
    public String roleList(Model model){
        List<Role> roleList=roleService.findAllRole();
        model.addAttribute("roles",roleList);
        return "role/list";
    }
    @RequestMapping(value="/new",method = RequestMethod.GET)
    public String newRole(){
        return "role/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveRole(Role role, RedirectAttributes redirectAttributes){
        roleService.saveRole(role);
        return "redirect:/role";
    }
    @RequestMapping(value = "/{id:\\d+}/del",method=RequestMethod.GET)
    public String delRole(@PathVariable Integer id){
        roleService.delRole(id);
        return "redirect:/role";
    }
}
