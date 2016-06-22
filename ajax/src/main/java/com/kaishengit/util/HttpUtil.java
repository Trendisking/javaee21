package com.kaishengit.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 20330 on 2016/6/21.
 */
public class HttpUtil {
    public static String getRequestText(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //创建一个get请求
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if (httpCode == 200) {
                //getEntity获得响应实体，getContent()输入流，获得网页的字符流
                InputStream inputStream = httpResponse.getEntity().getContent();
                String html = IOUtils.toString(inputStream);
                return html;

            } else {
                throw new RuntimeException("请求服务器异常: "+httpCode);
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }finally{
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void getRequestStream(String url,String savePath){

        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建一个get请求
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if (httpCode == 200) {
                //getEntity获得响应实体，getContent()输入流，获得图片的字节流
                InputStream inputStream = httpResponse.getEntity().getContent();
                FileOutputStream outputStream = new FileOutputStream(savePath);
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
                outputStream.close();
                inputStream.close();

            } else {
                throw new RuntimeException("请求服务器异常: "+httpCode);
            }
            httpClient.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally{
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
