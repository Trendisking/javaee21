package com.kaishengit.dto;

/**
 * Created by 20330 on 2016/7/31.
 */
public class FlashMessage {
    public static final String STATE_SUCCESS="success";
    public static final String STATE_ERROR="error";

    public FlashMessage(String message){
        this.state=STATE_SUCCESS;
        this.message=message;
    }

    public FlashMessage(String state,String message){
        this.state=state;
        this.message=message;
    }
    private String state;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
