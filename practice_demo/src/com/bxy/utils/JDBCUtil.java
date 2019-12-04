package com.bxy.utils;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：这是一个连接数据库的工具类
 *
 */
public class JDBCUtil {

	// 声明连接数据库的静态变量信息
    static String driverClass;
    static String url;
    static String username;
    static String password;

    static {
        try {
        	// 读取连接数据库的配置文件
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(in);
            // 为静态变量赋值
            driverClass = prop.getProperty("jdbc.driverClass");
            url = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            // 加载数据库驱动
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获得连接对象
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // 定义关闭资源的方法
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {}
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

    // 重载关闭方法
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }


}
