package com.srs.imooc.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //项目启动即初始化
        System.out.println("FirstListener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //项目关闭即销毁4
        System.out.println("FirstListener init");
    }
}
