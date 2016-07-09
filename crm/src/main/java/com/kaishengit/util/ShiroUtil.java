package com.kaishengit.util;

import com.kaishengit.pojo.User;
import org.apache.shiro.SecurityUtils;

/**
 * Created by 20330 on 2016/7/8.
 */
public class ShiroUtil {
    public static User getCurrentUser(){
       return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getCurrentUserId(){
        return getCurrentUser().getId();
    }
    public static String getCurrentUserName(){
        return getCurrentUser().getUsername();
    }
}
