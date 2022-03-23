package com.srs.biz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author shaorensheng
 * @date 2022/3/16
 */
@Repository
public class ClassDAO {
    public ClassDAO() {
        System.out.println("实例化ClassDAO");
    }

    public void insertStu() {
        System.out.println("新生入班");
    }
}
