package com.srs.spring;

import com.srs.biz.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.inserStu();
    }


}
