package com.kaishengit.controller;

import com.kaishengit.dto.FlashMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 20330 on 2016/7/30.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    /*去登录面*/
    @RequestMapping(value = "/",method=RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String login(String username, String password,
                        RedirectAttributes redirectAttributes, HttpServletRequest request){
        Subject subject= SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            //当前用户已经登录，则先退出之前的账号
            subject.logout();

        }
        try{
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            //获取登录的ip地址,并保存用户登录的日志

            return "redirect:/home";

        }catch (LockedAccountException ex){
            redirectAttributes.addFlashAttribute("message",new FlashMessage(FlashMessage.STATE_ERROR,"该账号已被禁用"));
        }catch(AuthenticationException exception){
            //exception.printStackTrace();
            //System.out.println("登录异常");
            redirectAttributes.addFlashAttribute("message",new FlashMessage(FlashMessage.STATE_ERROR,"账号或密码错误"));
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes){
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message",new FlashMessage("您已安全退出"));
        return "redirect:/";
    }
    @RequestMapping("/403")
    public String error403(){
        return "error/403";
    }
}
