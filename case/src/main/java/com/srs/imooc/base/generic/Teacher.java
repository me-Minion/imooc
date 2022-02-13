package com.srs.imooc.base.generic;

public class Teacher extends Person {
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(this.getName()  + "在讲课");
    }
}
