package com.kaishengit.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by 20330 on 2016/7/28.
 */
public class Father<T,PK> {
    public Father(){
        Class<?> clazz=this.getClass();
        ParameterizedType type=(ParameterizedType)clazz.getGenericSuperclass();
        Type[] types=type.getActualTypeArguments();

        Class<?> paramClass=(Class<?>)types[0];
        System.out.println(paramClass);
    }
}
