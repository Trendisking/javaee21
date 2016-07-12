package com.kaishengit.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 20330 on 2016/7/8.
 */
public class ServletUtil {
    /*获取客户端ip地址*/
    public static String getRemoteIp(HttpServletRequest request){
        String ip=request.getRemoteAddr();
        if("0:0:0:0:0:0:0:1".equals(ip)){
            ip="127.0.0.1";
        }
        return ip;
    }
}
