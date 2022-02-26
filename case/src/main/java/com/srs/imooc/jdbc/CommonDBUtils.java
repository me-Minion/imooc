package com.srs.imooc.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class CommonDBUtils {


    /**
     * CommonDBUtils + Druid
     * Druid 管理连接池
     * CommonDBUtils 主要用来封装返回的结果集
     * @param args
     */
    public static void main(String[] args) {
        select();
        System.out.println("---------");
        update();
        System.out.println("---------");
        select();
    }

    public static void update() {
        //1、加载属性文件
        String path = CommonDBUtils.class.getResource("/druid-config.properties").getPath();
        Properties properties = new Properties();
        try {
            path = URLDecoder.decode(path, "UTF-8");
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
            //关闭自动提交；手动提交
            conn.setAutoCommit(false);
            String sql1 ="update goods set price = price + 1000 where id = ?";
            String sql2 ="update goods set price = price - 500 where id = ?";
            QueryRunner qr = new QueryRunner(dataSource);
            qr.update(sql1, new Object[]{2});
            qr.update(sql2, new Object[]{3});
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, null, conn);
        }

    }


    public static void select() {
        //1、加载属性文件
        String path = CommonDBUtils.class.getResource("/druid-config.properties")
                .getPath();
//        String path = CommonDBUtils.class.getResource("/druid-config.properties").getPath();
        Properties properties = new Properties();
        try {
            path = URLDecoder.decode(path, "UTF-8");
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
            //下边开始使用CommonDBUtils查询数据
            QueryRunner qr = new QueryRunner(dataSource);
            String sql = "select * from goods limit ?,10";
            //sql + 返回的结果集类型 + 参数
            List<Goods> query = qr.query(sql, new BeanListHandler<>(Goods.class), new Object[]{0});
            for (Goods goods : query) {
                System.out.println(goods.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, null, conn);
        }

    }


}
