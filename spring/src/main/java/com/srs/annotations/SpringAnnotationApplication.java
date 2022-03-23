package com.srs.annotations;

import com.srs.biz.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shaorensheng
 * @date 2022/3/17
 */
public class SpringAnnotationApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationAnnotationContext.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.inserStu();
    }


}
