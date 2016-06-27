package com.kaishengit.web;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20330 on 2016/6/23.
 */
@WebServlet("/user.json")
public class UserJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<User> userList=new ArrayList<>();
        userList.add(new User(1,"jack","USK",49.5F));
        userList.add(new User(28,"尼古拉斯.凯奇","UK",80F));
        userList.add(new User(36,"尼古拉斯.赵四 ","US",99.5F));
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.print(new Gson().toJson(userList));
        out.flush();
        out.close();
    }
}
