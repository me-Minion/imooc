package com.srs.imooc.jdbc;

import java.sql.*;

public class DBUtil {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/imooc?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&CharacterEncoding=utf-8";
        String user = "root";
        String passwrod = "sheng0903";
        return  DriverManager.getConnection(url, user, passwrod);

    }


    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
