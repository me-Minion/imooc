package com.srs.spring.aspect;



import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 打印执行时间
 * @author shaorensheng
 * @date 2022/3/16
 */
public class PrintExcutionTime {

    public void beforPrintTime(JoinPoint joinpoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        //获取目标类的类名
        String className = joinpoint.getTarget().getClass().getName();
        //获取目标方法名称
        String methodName = joinpoint.getSignature().getName();
        System.out.println(String.format("======在%s：调用类%s的%s方法======", now, className, methodName));
    }


    /**
     * after-return
     * @param joinpoint
     * @param ret
     */
    public void afterPrintTime(JoinPoint joinpoint, Object ret) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        //获取目标类的类名
        String className = joinpoint.getTarget().getClass().getName();
        //获取目标方法名称
        String methodName = joinpoint.getSignature().getName();
        System.out.println(String.format("======在%s：调用类%s的%s方法======", now, className, methodName));
    }

    /**
     * after-throwing
     * @param joinpoint
     * @param ret
     */
    public void afterPrintTimeThrowing(JoinPoint joinpoint, Throwable ret) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        //获取目标类的类名
        String className = joinpoint.getTarget().getClass().getName();
        //获取目标方法名称
        String methodName = joinpoint.getSignature().getName();
        System.out.println(String.format("======异常在%s：调用类%s的%s方法======", now, className, methodName));
    }



}
