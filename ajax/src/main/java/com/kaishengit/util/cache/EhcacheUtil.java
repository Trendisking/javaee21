package com.kaishengit.util.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * Created by 20330 on 2016/6/27.
 */
public class EhcacheUtil {
    private static CacheManager cacheManager=new CacheManager();
    public static void set(String key,Object value){
        Ehcache ehcache=cacheManager.getEhcache("mycache");
        Element element=new Element(key,value);
        ehcache.put(element);
    }
    public static Object get(String key){
        Ehcache ehcache=cacheManager.getEhcache("mycache");
        Element element=ehcache.get(key);
        if(element!=null){
            return element.getObjectValue();
        }
        return null;
    }
    public static void remove(String key){
        Ehcache ehcache=cacheManager.getEhcache("mycache");
        ehcache.remove(key);
    }
}
