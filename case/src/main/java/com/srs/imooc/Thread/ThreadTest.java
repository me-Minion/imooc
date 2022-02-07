package com.srs.imooc.Thread;

public class ThreadTest {


    public static void main(String[] args) {
        //1、
//        ThreadDemoOne one = new ThreadDemoOne();
//        one.start();

        //2、
//        Cat cat = new Cat();
//        Dog dog = new Dog();
//
//        new Thread(cat).start();
//        new Thread(dog).start();
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println("main thread");
//        }

        //3、每间隔1秒输出一个字母
        new Thread(new Letter()).start();
    }

}
