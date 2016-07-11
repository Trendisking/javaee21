package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/7/11.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Inject
    private UserService userService;

    @RequestMapping(value = "/users" ,method= RequestMethod.GET)
    public String userList(Model model){
        List<Role> roleList=userService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "admin/userlist";

    }
    @RequestMapping(value="/users/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<User> loadUsers(HttpServletRequest request){
        String draw=request.getParameter("draw");
        String start=request.getParameter("start");
        String length=request.getParameter("length");
        String keyword=request.getParameter("search[value]");
        keyword= Strings.toUTF8(keyword);
        Map<String,Object> params= Maps.newHashMap();

        params.put("start",start);
        params.put("length",length);
        params.put("keyword",keyword);

        List<User> userList=userService.findUserByParam(params);
        Long count=userService.findUserCount();
        Long filterCount=userService.findUserCountByParam(params);




        return new DataTablesResult<>(draw,userList,count,filterCount);

    }

    /**
     * 添加新用户
     */
    @RequestMapping(value = "/users/new",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(User user){
        userService.saveUser(user);
        return "success";

    }

    /**
     * 验证用户名是否可用(Ajax调用)
     */
    @RequestMapping(value = "/user/checkusername",method = RequestMethod.GET)
    @ResponseBody
    public String checkUserName(String username){
        User user =userService.findUserByUserName(username);
        if(user==null){
            return "true";
        }
        return "false";

    }
}
