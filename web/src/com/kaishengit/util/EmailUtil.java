package com.kaishengit.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 20330 on 2016/6/14.
 */
public class EmailUtil {
    private static Logger logger= LoggerFactory.getLogger(EmailUtil.class);
    public static void sendHtmlEmail(String toAddress,String subject,String html ){

        HtmlEmail htmlEmail=new HtmlEmail();
        htmlEmail.setHostName(Config.get("mail.hostname"));
        htmlEmail.setSmtpPort(Integer.parseInt(Config.get("mail.port")));
        htmlEmail.setAuthentication(Config.get("mail.username"),Config.get("mail.password"));
        htmlEmail.setCharset(Config.get("mail.charset"));
        try{
            htmlEmail.setFrom(Config.get("mail.fromEmail"));
            htmlEmail.addTo(toAddress);
            htmlEmail.setSubject(subject);
            htmlEmail.setHtmlMsg(html);
            htmlEmail.send();
            logger.debug("向{}成功发送邮件",toAddress);
        }catch (EmailException e){
            logger.error("向{}发送邮件失败",toAddress);
            throw new RuntimeException("发送邮件异常",e);

        }

    }
}
