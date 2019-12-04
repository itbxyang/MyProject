package com.bxy.dao.impl;

import com.bxy.dao.UserDao;
import com.bxy.domain.Employee;
import com.bxy.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ��model��ӿ�ʵ���ࣨ�������ݿ����ҵ���߼���
 *
 */
public class UserDaoImpl implements UserDao {

	
	 /**
	  * 
	  *	�޸�Ա����Ϣ
	  * @param emp1
	  */
    public void updateEmp(Employee emp1) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
        	// ͨ�����ݿ⹤����������
            conn = DBUtils.getConnection();
            // ����sql�޸����
            String sql = "update employee set ename = ?, job = ?, hiredate = ?,sal = ? where id = ?";
            // ���ִ��sql��Ԥ����ִ�ж���
            pstmt = conn.prepareStatement(sql);
            // ����ÿ��sql�ֶζ�Ӧ��ֵ
            pstmt.setString(1,emp1.getEname());
            pstmt.setString(2,emp1.getJob());
            pstmt.setDate(3, (Date) emp1.getHiredate());
            pstmt.setDouble(4,emp1.getSal());
            pstmt.setInt(5,emp1.getId());
            // ִ���޸�����
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	// ͨ�����ݿ⹤����ر���Դ
            DBUtils.close(conn,pstmt);
        }
    }
    
    
    /**
     * 
          *  ����id��ѯ�û���Ȼ�����޸�
     * @param id
     * @return
     */
    public Employee findEmpById(Integer id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee emp = null;
        try {
        	// ͨ�����ݿ⹤����������
            conn = DBUtils.getConnection();
            // ����sql��ѯ���
            String sql = "select * from employee where id = ?";
            // ���ִ��sql��Ԥ����ִ�ж���
            pstmt = conn.prepareStatement(sql);
            // ����sql��id�ֶζ�Ӧ��ֵ
            pstmt.setInt(1,id);
            // ִ�в�ѯ����
            rs = pstmt.executeQuery();
            // �Ѳ�ѯ�Ľ������װΪ����
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
        	// ͨ�����ݿ⹤����ر���Դ
            DBUtils.close(conn,pstmt,rs);
        }
        // ���ز�ѯ�ĵ�������
        return emp;
    }
	
	
	/**
	 * 
          *  ��ѯ����Ա����Ϣ
     * @return
     */
    public List<Employee> findAllEmp() {
    	// ����һ������������ȡ��ѯ�Ķ���
        List<Employee> lists = new ArrayList<Employee>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	// ͨ�����ݿ⹤����������
            conn = DBUtils.getConnection();
            // ����sql��ѯ���
            String sql = "select * from employee";
            // ���ִ��sql��Ԥ����ִ�ж���
            pstmt = conn.prepareStatement(sql);
            // ִ�в�ѯ����
            rs = pstmt.executeQuery();
            // �Ѳ�ѯ�Ľ������װΪ���󲢴��뼯����
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                Employee emp = new Employee(id,ename,job,hiredate,sal);
                // �Ѷ�����ӵ�����
                lists.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	// ͨ�����ݿ⹤����ر���Դ
            DBUtils.close(conn, pstmt,rs);
        }
        // ���ؼ���
        return lists;
    }


   

   

   
}

