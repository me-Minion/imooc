package com.srs.biz.entity;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    public Student() {
        System.out.println("实例化Student");
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
