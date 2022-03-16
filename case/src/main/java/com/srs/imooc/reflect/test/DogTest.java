package com.srs.imooc.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DogTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.test.Dog");
            //无参实例化
            Dog dog = (Dog) aClass.newInstance();
            System.out.println("--------------------");
            //有参实例化
            Constructor<?> constructor = aClass.getConstructor(new Class[]{String.class, Integer.class});
            Dog dog1 = (Dog) constructor.newInstance(new Object[]{"斗牛", 2});
            System.out.println(dog1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
