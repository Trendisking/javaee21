package com.kaishengit.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 20330 on 2016/6/17.
 */
public class LogTstCase {
    private Logger logger= LoggerFactory.getLogger(LogTstCase.class);
    public void main(String[] args){
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
    }
}
