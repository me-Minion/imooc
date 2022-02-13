package com.srs.imooc.base.generic;

public abstract class Animal {


    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void paly();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
