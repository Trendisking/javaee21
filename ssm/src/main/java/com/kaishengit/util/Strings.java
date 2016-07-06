package com.kaishengit.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by 20330 on 2016/7/6.
 */
public class Strings  {
    public static String toUTF8(String str){
        if(StringUtils.isNotEmpty(str)){
            try {
                return new String(str.getBytes("ISO8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
               throw new RuntimeException("字符串转码异常");
            }
        }
        return "";
    }
}
