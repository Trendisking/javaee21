package com.kaishengit.test;

import com.kaishengit.util.EmailUtil;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

/**
 * Created by 20330 on 2016/6/14.
 */
public class MailTestCase {
    @Test
    public void sendTextMail() {
        SimpleEmail mail = new SimpleEmail();
        mail.setAuthentication("q3359255672", "hongjun1");
        mail.setHostName("smtp.126.com");
        mail.setSmtpPort(25);
        mail.setCharset("UTF-8");
        mail.setTLS(true);

        try {
            mail.setFrom("q3359255672@126.com");
            mail.setSubject("java.web");
            mail.setMsg("my god");
            mail.addTo("3359255672@qq.com");
            mail.send();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void sendHtmlMail() {
        HtmlEmail mail = new HtmlEmail();
        mail.setAuthentication("q3359255672", "hongjun1");
        mail.setHostName("smtp.126.com");
        mail.setSmtpPort(25);
        mail.setCharset("UTF-8");

        try {
            mail.setFrom("q3359255672@126.com");
            mail.setSubject("java.web.html");
            mail.setHtmlMsg("<div style=\'color:red\'>hello</div>");
            mail.addTo("2438731760@qq.com");
            mail.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendAttachMail() {

        EmailAttachment ea = new EmailAttachment();
        ea.setPath("F:/迅雷下载/1.png");
        MultiPartEmail mail = new MultiPartEmail();
        mail.setAuthentication("q3359255672", "hongjun1");
        mail.setHostName("smtp.126.com");
        mail.setSmtpPort(25);
        mail.setCharset("UTF-8");

        try {
            mail.setFrom("q3359255672@126.com");
            mail.setSubject("java.web");
            mail.setMsg("my god");
            mail.addTo("2438731760@qq.com");
             mail.attach(ea);
            mail.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSendHtmlEmail(){
        EmailUtil.sendHtmlEmail("2438731760@qq.com","今晚敲代码","<h3>web</h3>");

    }



}
