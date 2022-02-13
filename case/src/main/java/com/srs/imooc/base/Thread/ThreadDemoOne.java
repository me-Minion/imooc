package com.srs.imooc.base.Thread;

public class ThreadDemoOne extends Thread {


    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("打印机正在打印" + i);
        }
    }
}
