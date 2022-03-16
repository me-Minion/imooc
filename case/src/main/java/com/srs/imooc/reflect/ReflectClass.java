package com.srs.imooc.reflect;

import com.srs.imooc.reflect.entity.Student;

public class ReflectClass {

    /**
     * 以Class方式创建对象
     * @param args
     */
    public static void main(String[] args) {
        try {
            //此行会触发初始化（静态代码块会输出）
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.entity.Student");
            //此行会创建对象（无参构造器被调用）
            Student student = (Student) aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
