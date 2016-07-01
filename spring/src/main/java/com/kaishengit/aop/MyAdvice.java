package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by 20330 on 2016/6/30.
 */
public class MyAdvice {
    /*前置通知*/
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    //result 相当于把方法的返回值传到后置通知的参数里面
    public void afterReturningAdvice(Object result){
        System.out.println("后置通知" + result);
    }
    public void exceptionAdvice(Exception e){
        System.out.println("异常通知" + e.getMessage());
    }
    public void finallyAdvice(){
        System.out.println("最终通知");
    }
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object object=null;
        try {
            System.out.println("---前置通知---");
            object=joinPoint.proceed();//代表了目标对象方法的执行。
            System.out.println("---后置通知---"+object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("---异常通知---");
        }finally{
            System.out.println("---最终通知---");
        }
        return object;
    }
}
