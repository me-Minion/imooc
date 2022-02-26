package com.srs.imooc.jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCDemo1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/imooc?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&CharacterEncoding=utf-8";
        String user = "root";
        String passwrod = "sheng0903";

//        insert(url, user, passwrod);
        //基本查询
//        queryOne(url, user, passwrod);
        //预编译查询
        queryPrepared(url, user, passwrod);


    }


    private static void insert(String url, String user, String passwrod) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DriverManager.getConnection(url, user, passwrod);
            String sql = "insert into goods (name, price, desp) values (?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"手机");
            pstmt.setBigDecimal(2,new BigDecimal("2000"));
            pstmt.setString(3,"黑色，存储容量32G");

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 最基础的查询
     * @param url
     * @param user
     * @param passwrod
     */
    private static void queryOne(String url, String user, String passwrod) {
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, user, passwrod);
            stat = connection.createStatement();
            String sql = "select * from goods where price < 3500";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("name") + "-" + rs.getBigDecimal("price") + "-"+ rs.getString("desp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stat.close();
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 使用预编译的方式查询
     * @param url
     * @param user
     * @param passwrod
     */
    private static void queryPrepared(String url, String user, String passwrod) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, user, passwrod);
            String sql = "select * from goods where price < ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setBigDecimal(1, new BigDecimal("3500"));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("name") + "-" + rs.getBigDecimal("price") + "-"+ rs.getString("desp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
