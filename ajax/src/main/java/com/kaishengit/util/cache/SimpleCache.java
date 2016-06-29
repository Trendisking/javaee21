package com.kaishengit.util.cache;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by 20330 on 2016/6/27.
 */
public class SimpleCache {
    private static Map<String,Object> cache=new Hashtable<>();
    public static Object get(String key){
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return null;
    }
    public static void set(String key,Object value){
       cache.put(key,value);
    }
    public static void remove(String key){
        cache.remove(key);
    }
}
