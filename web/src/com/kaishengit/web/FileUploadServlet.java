package com.kaishengit.web;

import com.kaishengit.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by 20330 on 2016/6/16.
 */
@WebServlet("/servlet/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String description = req.getParameter("description");
        logger.debug("文件描述为{}", description);

        Part part = req.getPart("doc");

        InputStream inputStream=part.getInputStream();
        DocumentService documentService=new DocumentService();
        documentService.updateFile(getFileName(part),part.getSize(),inputStream);





        /*
        String contentType = part.getContentType();
        logger.debug("获取文件的ContentType:{}", contentType);
        long size = part.getSize();
        logger.debug("文件大小{}", size);
        String fileName = getFileName(part);
        logger.debug("文件的原名:{}",fileName);
        saveFile(part);*/


    }

    /*public void saveFile(Part part) throws IOException {
        File dir=new File("F:/upload");
        System.out.println(dir.exists());
        if(!dir.exists()){
            dir.mkdirs();
        }

        String fileName=getFileName(part);
        String extName=fileName.substring(fileName.indexOf("."));
        String uuid= UUID.randomUUID().toString();
        fileName=uuid+extName;

        InputStream inputStream=part.getInputStream();
        FileOutputStream outputStream=new FileOutputStream(new File(dir,getFileName(part)));
        IOUtils.copy(inputStream,outputStream);
        /*InputStream inputStream=part.getInputStream();
        FileOutputStream outputStream=new FileOutputStream(new File(dir,getFileName(part)));
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
        byte[] buffer=new byte[1024];
        int length=-1;
        while((length=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer,0,length);

        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }*/

    private String getFileName(Part part) throws UnsupportedEncodingException {
        String headerValue = part.getHeader("Content-Disposition");
        headerValue=headerValue.substring(headerValue.indexOf("filename=\""));
        headerValue=headerValue.substring(headerValue.indexOf("\"")+1,headerValue.length()-1);

        return headerValue;
    }
}



