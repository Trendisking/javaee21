package com.kaishengit.test;

import org.joda.time.DateTime;
import org.junit.Test;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.FontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import java.awt.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 20330 on 2016/6/13.
 */
public class MyTestCase {
    @Test
    public void testUUID(){
        UUID uuid=UUID.randomUUID();
        String key=uuid.toString();
        System.out.println(key);

    }
    @Test
    public void testCaptcha() throws Exception{
        ConfigurableCaptchaService cs=new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(67,78,170) ));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

        RandomWordFactory randomWordFactory=new RandomWordFactory();
        randomWordFactory.setMaxLength(4);
        randomWordFactory.setMinLength(4);
        randomWordFactory.setCharacters("0123456789啊果然人的老人高科荣欸宝贝了");
        cs.setWordFactory(randomWordFactory);

        cs.setFontFactory(new FontFactory() {
            @Override
            public Font getFont(int i) {
                return new Font("微软雅黑",Font.ITALIC,24);
            }
        });

        FileOutputStream outputStream=new FileOutputStream("D:/captcha.png");
        EncoderHelper.getChallangeAndWriteImage(cs,"png",outputStream);
        outputStream.flush();
        outputStream.close();

    }

    @Test
    public void testTime(){
        Date date=new Date();
        long timeStamp=date.getTime();
        System.out.println(timeStamp);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(date);
        System.out.println(now);
    }
    @Test
    public void testJodaTime(){
        DateTime dateTime=DateTime.now();
        dateTime=dateTime.plusDays(25);
        dateTime=dateTime.plusHours(50);
        String now= dateTime.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(now);

    }
    @Test
    public void testSubString(){
        String headerValue="form-data; name=\"doc\"; filename=\"DSCF4160.jpg\"";
        headerValue=headerValue.substring(headerValue.indexOf("filename=\""));
        headerValue=headerValue.substring(headerValue.indexOf("\"")+1,headerValue.length()-1);

        System.out.println(headerValue);

    }

}
