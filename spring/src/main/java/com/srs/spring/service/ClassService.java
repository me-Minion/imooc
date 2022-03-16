package com.srs.spring.service;

import com.srs.spring.dao.ClassDAO;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
public class ClassService {

    private ClassDAO classDAO;

    public ClassService() {
        System.out.println("实例化ClassService");
    }

    public ClassDAO getClassDAO() {
        return classDAO;
    }

    public void setClassDAO(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    public void insertStu() {
        System.out.println("ClassService新生入班");
        classDAO.insertStu();
    }
}
