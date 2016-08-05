package com.kaishengit.util;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by 20330 on 2016/7/28.
 */
public class SearchParam {
    private String type;
    private String propertyName;
    private Object value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public static List<SearchParam> builderSearchParam(HttpServletRequest request){
        List<SearchParam> searchParamList= Lists.newArrayList();

        //1.获取所有的查询字符串
        Enumeration<String> enumeration=  request.getParameterNames();
        while (enumeration.hasMoreElements()){
            String queryString=enumeration.nextElement();
            Object value=request.getParameter(queryString);
            if(queryString.startsWith("q_")&& value!=null&&StringUtils.isNotEmpty(value.toString())){
                //q_f_like_xxx
                String[] array=queryString.split("_",4);
                if(array.length!=4){
                    throw new RuntimeException("地址栏查询字符串格式错误:"+queryString);
                }
                String type=array[2];
                String propertyName=array[3];
                String valueType=array[1];
                SearchParam searchParam=new SearchParam();
                searchParam.setPropertyName(propertyName);
                value=converterType(value,valueType);
                searchParam.setValue(value);
                searchParam.setType(type);
                searchParamList.add(searchParam);
                request.setAttribute(queryString,value);

            }
        }
        return searchParamList;

    }

    private static Object converterType(Object value, String valueType) {
        if("s".equalsIgnoreCase(valueType)){
            return Strings.toUTF8(value.toString());
        }else if("b".equalsIgnoreCase(valueType)){
            return Boolean.valueOf(value.toString());
        }else if("d".equalsIgnoreCase(valueType)){
            return Double.valueOf(value.toString());
        }else if("f".equalsIgnoreCase(valueType)){
            return Float.valueOf(value.toString());
        }else if("i".equalsIgnoreCase(valueType)){
            return Integer.valueOf(value.toString());
        }
        return null;

    }
}
