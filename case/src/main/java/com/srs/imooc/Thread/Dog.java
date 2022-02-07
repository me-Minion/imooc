package com.srs.imooc.Thread;

public class Dog implements Runnable {
    public Dog() {
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "A dog");
        }
    }
}
