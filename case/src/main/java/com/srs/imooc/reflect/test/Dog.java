package com.srs.imooc.reflect.test;

public class Dog {

    static {
        System.out.println("Dog类已经别加载到JVM中，并已初始化");
    }

    private String name;
    private Integer age;

    public Dog() {
        System.out.println("Dog无参实例化");
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Dog有参实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
