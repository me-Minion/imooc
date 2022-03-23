package com.srs.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切面环绕通知, 以注解的方式实现
 * @author shaorensheng
 * @date 2022/3/17
 */
@Component
@Aspect
public class AroundPrintExcutionTime {


    @Pointcut("@annotation(com.srs.spring.aspect.Logging)")
    public void cut(){

    };

    /*
    execution 表达式不太灵活
    使用自定义注解可以灵活配置哪些地方需要切面
    自定义注解：
    ① 创建自定义的注解类@Annotation， Java文件叫做Annotation，用@interface表示。
    ② 增加元注解 @interface上面按需要注解上一些东西，包括@Retention、@Target、@Document、@Inherited四种。
        1、增加注解
            @Documented---> 表名这个注解应该被javadoc工具记录
            @Retention(RetentionPolicy.RUNTIME)---> 注解声明周期 ；使用RetentionPolicy枚举;
                RetentionPolicy.SOURCE 注解仅存在于源码中，在class字节码文件中不包含
                RetentionPolicy.CLASS 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获取
                RetentionPolicy.RUNTIME 会在class字节码文件中存在，在运行时可以通过反射获取到
            @Target(ElementType.METHOD)---> 注解作用范围；使用ElementType枚举
                @Target(ElementType.TYPE)    接口、类、枚举、注解     ---可能会用到
                @Target(ElementType.FIELD)   字段、枚举的常量        ---可能会用到
                @Target(ElementType.METHOD)  方法               ----大概率用到
                @Target(ElementType.PARAMETER)      方法
                @Target(ElementType.CONSTRUCTOR)      构造函数
                @Target(ElementType.LOCAL_VARIABLE)    局部变量
                @Target(ElementType.ANNOTATION_TYPE)  注解
                @Target(ElementType.PACKAGE)          包
            @Inherited  ---> 注解可以被继承
     */
    //@Around("execution(* com.srs.biz..*.*(..))")
    @Around("cut()")
    public void printTime(ProceedingJoinPoint pjp) throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        //获取目标类的类名
        String className = pjp.getTarget().getClass().getName();
        //获取目标方法名称
        String methodName = pjp.getSignature().getName();
        System.out.println(String.format("====方法执行前获取==在%s：调用类%s的%s方法======", now, className, methodName));
        //目标方法执行
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            //此处既可以原封不动的抛出异常，也可以自己单独处理
            throw throwable;
        }

        System.out.println("方法执行后");
    }



}
