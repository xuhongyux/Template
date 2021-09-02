package com.xiayu.feign.consumer.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xuhongyu
 * @create 2021-06-21 15:01
 */
public class JDBCUtil {
    public static final String DB_URL = "jdbc:mysql://47.117.179.252:3306/intelligent_process_dev?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true";
    public static final String DB_NAME = "debian-sys-maint";
    public static final String DB_PWD = "CCSv1FHDzYMPWZOO";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取得连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void free(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



