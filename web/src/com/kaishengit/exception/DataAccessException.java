package com.kaishengit.exception;

/**
 * Created by 20330 on 2016/6/12.
 */
public class DataAccessException extends RuntimeException{
    public DataAccessException(){}

    public DataAccessException(String msg){
        super(msg);
    }

    public DataAccessException(String msg,Exception ex){
        super(msg,ex);
    }
}
