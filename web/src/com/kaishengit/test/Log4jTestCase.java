package com.kaishengit.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 20330 on 2016/6/13.
 */
public class Log4jTestCase {
    @Test
    public void testLog(){
        String name="tony";
        String bookName="《择天记》";
        Logger logger= LoggerFactory.getLogger(Log4jTestCase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("{}借阅了{}",name,bookName);
        logger.warn("warn message");
        logger.error("error message");


    }
}
