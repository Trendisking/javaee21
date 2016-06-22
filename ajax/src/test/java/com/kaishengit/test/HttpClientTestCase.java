package com.kaishengit.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 20330 on 2016/6/21.
 */
public class HttpClientTestCase {
    //http://f10.topitme.com/l/201102/23/12983922974337.jpg

    @Test
    public void testDownLoadImage() throws IOException {
        //创建一个浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建一个get请求
        HttpGet httpGet=new HttpGet("http://f10.topitme.com/l/201102/23/12983922974337.jpg");
        HttpResponse httpResponse=httpClient.execute(httpGet);
        int httpCode=httpResponse.getStatusLine().getStatusCode();
        if(httpCode==200){
            //getEntity获得响应实体，getContent()输入流，获得图片的字节流
            InputStream inputStream=httpResponse.getEntity().getContent();
            FileOutputStream outputStream=new FileOutputStream("D:/image.jpg");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        }else{
            System.out.println("请求异常　："+ httpCode);
        }
        httpClient.close();

    }




    @Test
    public void testGetRequest() throws IOException {
        //创建一个浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建一个get请求
        HttpGet httpGet=new HttpGet("http://blog.sina.com.cn/rss/1220218113.xml");
        HttpResponse httpResponse=httpClient.execute(httpGet);
        int httpCode=httpResponse.getStatusLine().getStatusCode();
        if(httpCode==200){
            //getEntity获得响应实体，getContent()输入流，获得网页的字符流
            InputStream inputStream=httpResponse.getEntity().getContent();
            String html= IOUtils.toString(inputStream);
            System.out.println(html);

        }else{
            System.out.println("请求异常　："+ httpCode);
        }
        httpClient.close();

    }
}
