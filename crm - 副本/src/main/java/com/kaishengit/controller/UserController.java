package com.kaishengit.controller;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.service.UserService;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 20330 on 2016/7/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Inject
    private UserService userService;
    /*修改密码*/
    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String editPassword(){
       return "setting/password";
    }
    @RequestMapping(value = "/password",method = RequestMethod.POST)
    @ResponseBody
    public String editPassword(String password){
        userService.changePassword(password);
        return "success";
    }

    /*验证初始密码是否正确(Ajax调用，有X-Request-With请求头)*/
    @RequestMapping(value="/validate/password",method=RequestMethod.GET)
    @ResponseBody
    public String validateOldPassword(@RequestHeader("X-Requested-With") String XRequestedWith, String oldpassword){
        if("XMLHttpRequest".equals(XRequestedWith)){
            User user= ShiroUtil.getCurrentUser();
            if(user.getPassword().equals(DigestUtils.md5Hex(oldpassword))){
                return "true";
            }
            return "false";
        }else{
            throw new NotFoundException();
        }
    }

    /*显示当前用户的登录日志*/
    @RequestMapping(value = "/log",method = RequestMethod.GET)
    public String showUserLog(){
        return "setting/loglist";
    }

    /*使用DataTables显示数据*/
    @RequestMapping(value="/log/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult userLogLoad(HttpServletRequest request){
        String draw=request.getParameter("draw");
        String start=request.getParameter("start");
        String length=request.getParameter("length");

        List<UserLog> userLogList=userService.findCurrentUserLog(start,length);
        Long count=userService.findCurrentUserLogCount();



        return new DataTablesResult<>(draw,userLogList,count,count);

    }
}
