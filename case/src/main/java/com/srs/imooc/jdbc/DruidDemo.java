package com.srs.imooc.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {

    /**
     * Druid练习
     * @param args
     */
    public static void main(String[] args) {

        //1、加载属性文件
        String path = DruidDemo.class.getResource("/druid-config.properties").getPath();
        Properties properties = new Properties();
        try {
            path = URLDecoder.decode(path, "UTF-8");
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2、获取DataSource数据源对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //3、创建数据库链接
            conn = dataSource.getConnection();
            String sql = "select * from goods";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-" + rs.getString("name") + "-" + rs.getBigDecimal("price") + "-"+ rs.getString("desp") + "-" + rs.getDate("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, conn);
        }

    }


}
