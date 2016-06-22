package com.kaishengit.web;

import com.kaishengit.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 20330 on 2016/6/21.
 */
@WebServlet("/load")
public class LoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String url=req.getParameter("url");
        String xml= HttpUtil.getRequestText(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.print(xml);
        out.flush();
        out.close();
    }
}
