package com.srs.imooc.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BookTest {


    public static void main(String[] args) {
        try {
            //有参构造器，实例化book对象
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.test.Book");
            Constructor<?> constructor = aClass.getConstructor(new Class[]{Integer.class, String.class, Float.class});
            Book book = (Book) constructor.newInstance(new Object[]{1, "十万个为什么", 29f});
            System.out.println(book);
            System.out.println("---------------------------");

            //获取所有成员，判断public或private的修饰，并输出内容
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getModifiers() == 1) {
                    //public 修改
                    Object o = field.get(book);
                    System.out.println(field.getName() + ":" + o);
                } else if (field.getModifiers() == 2) {
                    //private 修饰
                    //获取方法名
                    String methodName = "get" + field.getName().substring(0, 1).toUpperCase() +
                            field.getName().substring(1);
                    //通过方法名获取方法
                    Method method = aClass.getMethod(methodName);
                    //调用book对象的方法，返回结果值
                    Object invoke = method.invoke(book);
                    System.out.println(field.getName() + ":" + invoke);
                }
            }
            /*
             * Book有参构造器
             * Book{no=1, name='十万个为什么', price=29.0}
             * ---------------------------
             * no:1
             * name:十万个为什么
             * price:29.0
             */


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
