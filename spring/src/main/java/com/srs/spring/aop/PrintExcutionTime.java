package com.srs.spring.aop;



import org.aopalliance.intercept.Joinpoint;

import java.lang.reflect.AccessibleObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 打印执行时间
 * @author shaorensheng
 * @date 2022/3/16
 */
public class PrintExcutionTime {

    public void printTime(Joinpoint joinpoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
    }



}
