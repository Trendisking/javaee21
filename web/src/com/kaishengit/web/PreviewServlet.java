package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumentService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 20330 on 2016/6/19.
 */
@WebServlet("/preview")
public class PreviewServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5=req.getParameter("file");
        String down=req.getParameter("down");
        if(StringUtils.isNotEmpty(md5)){
            Document document=new DocumentService().findDocumentByMd5(md5);
            if(document==null){
                resp.sendError(404);
            }else{
                String saveFileName=document.getSavename();
                File file=new File("D:/upload",saveFileName);
                if(file.exists()){
                    if("true".equals(down)){
                        //浏览器弹出另存为对话框
                        resp.setContentType("application/octet-stream");
                        //设置对话框中的文件名
                        String fileName=new String(document.getFilename().getBytes("UTF-8"),"ISO8859-1");
                        resp.addHeader("Content-disposition","attachment;filename=\""+fileName+"\"");
                        //设置文件大小，浏览器会显示有进度的进度条
                        resp.setContentLength(document.getSize().intValue());
                    }

                    FileInputStream fileInputStream=new FileInputStream(file);
                    OutputStream outputStream=resp.getOutputStream();//响应输出流
                    IOUtils.copy(fileInputStream,outputStream);
                    outputStream.flush();
                    outputStream.close();
                    fileInputStream.close();
                }else{
                    resp.sendError(404);
                }
            }
        }resp.sendError(404);

    }
}
