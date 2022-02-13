package com.srs.imooc.base.generic;

public class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(this.getName() + "在学习");
    }
}
