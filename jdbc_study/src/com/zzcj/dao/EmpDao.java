package com.zzcj.dao;

import com.zzcj.domain.Emp;
import com.zzcj.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Emp> findAllEmp() {
        List<Emp> lists = new ArrayList<Emp>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from emp";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                Emp emp = new Emp(id,ename,job,hiredate,sal);
                lists.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt,rs);
        }

        return lists;
    }

    /**
     * 添加员工信息
     * @param emp
     */
    public void addEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into emp values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,emp.getId());
            pstmt.setString(2,emp.getEname());
            pstmt.setString(3,emp.getJob());
            pstmt.setDate(4, (Date) emp.getHiredate());
            pstmt.setDouble(5,emp.getSal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,pstmt);
        }
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public Emp findEmpById(Integer id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Emp emp = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from emp where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id1 = rs.getInt("id");
                String ename1 = rs.getString("ename");
                String job1 = rs.getString("job");
                Date hiredate1 = rs.getDate("hiredate");
                double sal1 = rs.getDouble("sal");
                emp = new Emp(id1,ename1,job1,hiredate1,sal1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,pstmt,rs);
        }
        return emp;
    }

    /**
     * 修改员工信息
     * @param emp1
     */
    public void updateEmpServlet(Emp emp1) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update emp set ename = ?, job = ?, hiredate = ?,sal = ? where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,emp1.getEname());
            pstmt.setString(2,emp1.getJob());
            pstmt.setDate(3, (Date) emp1.getHiredate());
            pstmt.setDouble(4,emp1.getSal());
            pstmt.setInt(5,emp1.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,pstmt);
        }
    }

    /**
     * 根据id删除员工信息
     * @param id
     */
    public void delEmp(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from emp where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,pstmt);
        }
    }
}
