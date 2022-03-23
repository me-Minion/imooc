package com.srs.biz.service;

import com.srs.biz.dao.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
@Repository
public class ClassService {

    @Autowired
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
