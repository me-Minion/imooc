package com.srs.imooc.Thread;

public class Cat implements Runnable {
    public Cat() {
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "A cat");
        }
    }
}
