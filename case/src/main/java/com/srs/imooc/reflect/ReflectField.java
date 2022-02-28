package com.srs.imooc.reflect;

import com.srs.imooc.reflect.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectField {

    /**
     * 操作成员变量
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.srs.imooc.reflect.entity.Student");
            Constructor<?> constructor = aClass.getConstructor(new Class[]{Integer.class, String.class});
            Student student = (Student) constructor.newInstance(3, "王五");
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                //只能获取到public的成员变量
                System.out.println(field.getName());
            }
            //name字段必须是public的，不然会报错
            Field nameField = aClass.getField("name");
            //从student对象中，获取name成员变量的值
            String name = (String) nameField.get(student);
            System.out.println(name);

            //此行可以设置成员变量的值，（设置student对象中name字段的值为李蕾）
            nameField.set(student, "李蕾");
            name = (String) nameField.get(student);
            System.out.println(name);

            //field只能获取public的成员变量，如何获取私有的呢？？？
            //使用getDeclared开头的Constructor(s)、Method(s)、Field(s)

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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
