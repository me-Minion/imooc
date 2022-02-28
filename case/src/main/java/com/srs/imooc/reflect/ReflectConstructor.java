package com.srs.imooc.reflect;

import com.srs.imooc.reflect.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructor {

    /**
     * 操作构造器
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.entity.Student");
            //以带参方式调用构造方法（通过参数列表，确定具体的方法）
            Constructor<?> constructor = aClass.getConstructor(new Class[]{
                    Integer.class, String.class
            });
            //方法的参数
            Object[] objects = {1, "张三"};
            //有参构造器初始化
            Student student = (Student) constructor.newInstance(objects);
            System.out.println(student);
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
