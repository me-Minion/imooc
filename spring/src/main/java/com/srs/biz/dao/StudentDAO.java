package com.srs.biz.dao;

import com.srs.spring.aspect.Logging;
import org.springframework.stereotype.Repository;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
@Repository
public class StudentDAO {

    public StudentDAO() {
        System.out.println("实例化StudentDAO");
    }

    @Logging
    public void insertStu() {
        System.out.println("StudentDAO insertStu新生信息");
    }



}
