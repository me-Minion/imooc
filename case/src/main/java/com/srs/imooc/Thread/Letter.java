package com.srs.imooc.Thread;

public class Letter implements Runnable {
//    char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] chars = new char[26];

    public Letter() {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(97 + i);
        }
    }

    @Override
    public void run() {
        for (char aChar : chars) {
            System.out.print(aChar);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
