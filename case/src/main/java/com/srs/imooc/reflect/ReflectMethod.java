package com.srs.imooc.reflect;

import com.srs.imooc.reflect.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {

    /**
     * 操作对象的方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.entity.Student");
            Constructor<?> constructor = aClass.getConstructor(new Class[]{Integer.class, String.class});
            Student student = (Student) constructor.newInstance(2, "张三");
            //name指定待调用的方法名，new Class[]参数列表（通过参数列表判断重写的方法）
            Method add = aClass.getMethod("add", new Class[]{Integer.class, Integer.class});
            //指定执行方法的对象 +  方法对应的参数
            Object invoke = add.invoke(student, new Object[]{10, 8});
            System.out.println(invoke);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
