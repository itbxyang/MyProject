package com.bxy.dao.impl;

import com.bxy.dao.UserDao;
import com.bxy.domain.Employee;
import com.bxy.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个model层接口实现类（操作数据库的主业务逻辑）
 *
 */
public class UserDaoImpl implements UserDao {

	
	 /**
	  * 
	  *	修改员工信息
	  * @param emp1
	  */
    public void updateEmp(Employee emp1) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	// 通过数据库工具类获得连接
            conn = DBUtils.getConnection();
            // 定义sql修改语句
            String sql = "update employee set ename = ?, job = ?, hiredate = ?,sal = ? where id = ?";
            // 获得执行sql的预编译执行对象
            pstmt = conn.prepareStatement(sql);
            // 设置每个sql字段对应的值
            pstmt.setString(1,emp1.getEname());
            pstmt.setString(2,emp1.getJob());
            pstmt.setDate(3, (Date) emp1.getHiredate());
            pstmt.setDouble(4,emp1.getSal());
            pstmt.setInt(5,emp1.getId());
            // 执行修改命令
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	// 通过数据库工具类关闭资源
            DBUtils.close(conn,pstmt);
        }
    }
    
    
    /**
     * 
          *  根据id查询用户，然后再修改
     * @param id
     * @return
     */
    public Employee findEmpById(Integer id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee emp = null;
        try {
        	// 通过数据库工具类获得连接
            conn = DBUtils.getConnection();
            // 定义sql查询语句
            String sql = "select * from employee where id = ?";
            // 获得执行sql的预编译执行对象
            pstmt = conn.prepareStatement(sql);
            // 设置sql的id字段对应的值
            pstmt.setInt(1,id);
            // 执行查询命令
            rs = pstmt.executeQuery();
            // 把查询的结果集封装为对象
            while(rs.next()){
                int id1 = rs.getInt("id");
                String ename1 = rs.getString("ename");
                String job1 = rs.getString("job");
                Date hiredate1 = rs.getDate("hiredate");
                double sal1 = rs.getDouble("sal");
                emp = new Employee(id1,ename1,job1,hiredate1,sal1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	// 通过数据库工具类关闭资源
            DBUtils.close(conn,pstmt,rs);
        }
        // 返回查询的单个对象
        return emp;
    }
	
	
	/**
	 * 
          *  查询所有员工信息
     * @return
     */
    public List<Employee> findAllEmp() {
    	// 定义一个集合用来存取查询的对象
        List<Employee> lists = new ArrayList<Employee>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	// 通过数据库工具类获得连接
            conn = DBUtils.getConnection();
            // 定义sql查询语句
            String sql = "select * from employee";
            // 获得执行sql的预编译执行对象
            pstmt = conn.prepareStatement(sql);
            // 执行查询命令
            rs = pstmt.executeQuery();
            // 把查询的结果集封装为对象并存入集合中
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                Employee emp = new Employee(id,ename,job,hiredate,sal);
                // 把对象添加到集合
                lists.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	// 通过数据库工具类关闭资源
            DBUtils.close(conn, pstmt,rs);
        }
        // 返回集合
        return lists;
    }


   

   

   
}

