package com.srs.imooc.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GoodsTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.test.Goods");
            //使用有参构造器实例化对象
            Constructor<?> constructor = aClass.getConstructor(new Class[]{Integer.class, String.class, Float.class, String.class});
            Goods tv = (Goods) constructor.newInstance(1, "电视", 2999f, "LED电视");
            //Goods{no=1, name='电视', price=2999.0, desc='LED电视'}
            System.out.println(tv);
            System.out.println("-----------------------");
            //通过Method调用tv的display方法更改商品描述
            Method display = aClass.getMethod("display", String.class);
            display.invoke(tv, "89英寸");
            //Goods{no=1, name='电视', price=2999.0, desc='89英寸'}
            System.out.println(tv);
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
