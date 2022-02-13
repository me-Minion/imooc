package com.srs.imooc.base.generic;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void paly() {
        System.out.println("小猫" + this.getName() + "在做游戏！");
    }
}
