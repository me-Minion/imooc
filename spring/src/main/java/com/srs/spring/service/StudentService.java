package com.srs.spring.service;

import com.srs.spring.dao.StudentDAO;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        System.out.println("实例化StudentService");
    }

    public void inserStu () {
        System.out.println("StudentService学生入学");
        studentDAO.insertStu();;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
