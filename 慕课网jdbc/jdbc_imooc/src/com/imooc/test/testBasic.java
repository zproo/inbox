package com.imooc.test;

import java.sql.*;

/**
 * Created by zproo on 2017/11/13.
 */
public class testBasic {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        try {
            // 1.加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.通过数据库驱动获得数据库连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3.创建连接对象，通过数据库连接对象创建sql语句并执行
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT user_name, sex, age FROM imooc_goddess");
            while (rs.next()) {
                System.out.println("username: " + rs.getString("user_name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
