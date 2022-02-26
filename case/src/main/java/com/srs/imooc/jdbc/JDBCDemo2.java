package com.srs.imooc.jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCDemo2 {


    public static void main(String[] args) {
//        insert();
        select();
//        System.out.println("--------------------");
//        update();
//        select();
//        System.out.println("--------------------");
//        delete();
//        select();
//        System.out.println("--------------------");
    }


    public static void select() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from  goods;";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("name") + "-" + rs.getBigDecimal("price") + "-"+ rs.getString("desp") + "-" + rs.getDate("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(rs, pstmt, connection);
    }

    public static void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into goods (name, price, desp,create_time) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"电脑");
            pstmt.setBigDecimal(2, new BigDecimal("6999"));
            pstmt.setString(3,"华硕品质坚如磐石");
            java.util.Date date = new java.util.Date();
            //此处设置的Date是java.sql包下的，平时使用的util包下的Date，需要转换下
            //java.sql.Date继承自java.util.Date；取出来的时候可以直接用
            pstmt.setDate(4, new Date(date.getTime()));
            pstmt.executeUpdate();
            System.out.println("数据插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(null, pstmt, conn);
    }

    public static void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from goods where price > ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1, new BigDecimal("5500"));
            pstmt.executeUpdate();
            System.out.println("数据删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(null, pstmt, conn);
    }


    public static void update() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update goods set price = price + 300 where id > ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 3);
            pstmt.executeUpdate();
            System.out.println("数据更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(null, pstmt, conn);
    }


}
