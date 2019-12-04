package com.bxy.utils;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ���������ݿ�Ĺ�����
 *
 */
public class JDBCUtil {

	// �����������ݿ�ľ�̬������Ϣ
    static String driverClass;
    static String url;
    static String username;
    static String password;

    static {
        try {
        	// ��ȡ�������ݿ�������ļ�
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(in);
            // Ϊ��̬������ֵ
            driverClass = prop.getProperty("jdbc.driverClass");
            url = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            // �������ݿ�����
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ������Ӷ���
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // ����ر���Դ�ķ���
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

    // ���عرշ���
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }


}
