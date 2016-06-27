package com.kaishengit.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by 20330 on 2016/6/14.
 */
public class Config {
    private static Properties properties=new Properties();
    static{

        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("读取properties异常",e);

        }
    }

    public static String get(String Key){
        return properties.getProperty(Key);
    }
    public static String get(String Key,String defaultValue){
        return properties.getProperty(Key,defaultValue);
    }


}
