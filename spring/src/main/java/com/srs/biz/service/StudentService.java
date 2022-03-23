package com.srs.biz.service;

import com.srs.biz.dao.StudentDAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
@Service
public class StudentService {

    @Resource
    private StudentDAO studentDAO;

    public StudentService() {
        System.out.println("实例化StudentService");
    }

    public void inserStu () {
        System.out.println("StudentService学生入学");
        studentDAO.insertStu();;
        //throw new RuntimeException();
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
