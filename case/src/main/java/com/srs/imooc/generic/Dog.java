package com.srs.imooc.generic;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void paly() {
        System.out.println("小狗" + this.getName() + "在做游戏！");
    }
}
