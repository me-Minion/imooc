package com.srs.imooc.reflect;

import com.srs.imooc.reflect.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetDeclaredConstructor {


    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.entity.Student");
            Constructor<?> constructor = aClass.getConstructor(new Class[]{Integer.class, String.class, Integer.class});
            Student student = (Student) constructor.newInstance(4, "赵六", 31);


            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.getModifiers() == 1) {
                    //public修饰 可以直接取值
                    Object o = declaredField.get(student);
                    System.out.println(declaredField.getName() + ":" + o);
                } else if (declaredField.getModifiers() == 2) {
                    //private修饰 只能通过get方法取值
                    //1、获取get方法名称
                    String methodName = "get" + declaredField.getName().substring(0, 1).toUpperCase() +
                            declaredField.getName().substring(1);
                    //2、获取get方法
                    Method method = aClass.getMethod(methodName);
                    //3、调用对象的方法
                    Object invoke = method.invoke(student);
                    System.out.println(declaredField.getName() + ":" + invoke);
                } else {
                    //默认修饰符,不能直接获取，也得通过get方式
//                    System.out.println(declaredField.get(student));
                    //1、获取get方法名称
                    String methodName = "get" + declaredField.getName().substring(0, 1).toUpperCase() +
                            declaredField.getName().substring(1);
                    //2、获取get方法
                    Method method = aClass.getMethod(methodName);
                    //3、调用对象的方法
                    Object invoke = method.invoke(student);
                    System.out.println(declaredField.getName() + ":" + invoke);
                }
            }

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
