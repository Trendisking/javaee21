package com.kaishengit.exception;

/**
 * Created by 20330 on 2016/7/1.
 */

   //业务层的异常
public class ServiceException extends RuntimeException {

    public ServiceException(){}
    public ServiceException(String message){
        super(message);
    }


}
