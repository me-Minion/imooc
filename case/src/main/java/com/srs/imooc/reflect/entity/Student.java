package com.srs.imooc.reflect.entity;

public class Student {

    static {
        System.out.println("Student静态代码块");
    }

    private Integer id;

    public String name;

    public String desc;

    Integer age;

    public Student() {
        System.out.println("student无参构造器");
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Student带参构造器");
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int add(Integer a , Integer b) {
        System.out.println("add");
        return a + b;
    }

    public int str(Integer a,Integer b){
        System.out.println("str");
        return a - b;
    }

    public Student(Integer a, Integer b) {
        System.out.println("Student a + b = " + (a + b));
    }
}
