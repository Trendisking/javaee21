package com.kaishengit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 20330 on 2016/6/20.
 */
@WebServlet("/checkusername")
public class CheckUserNameServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(CheckUserNameServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在服务器端处理缓存
        //resp.setContentType("text/html;charset=UTF-8");
        //三个响应头告诉浏览器不要缓存相应结果
       // resp.addHeader("pragma","no-cache");
        //resp.addHeader("cache-control","no-cache");//不要缓存
        //resp.addHeader("expires","0");//设置缓存时间





        String username=req.getParameter("username");
        username=new String(username.getBytes("ISO8859-1"),"UTF-8");
        logger.debug("username:{}",username);
        PrintWriter out =resp.getWriter();
        if("tom".equals(username)){
            out.print("no");
        }else{
            out.print("yes");
        }
        out.flush();
        out.close();

    }
}
