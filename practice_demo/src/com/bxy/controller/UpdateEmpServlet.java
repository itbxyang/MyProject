package com.bxy.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bxy.domain.Employee;
import com.bxy.service.UserService;
import com.bxy.service.impl.UserServiceImpl;

/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ���޸�Ա����Ϣ��servlet��controller�㷽����
 *
 */
@WebServlet("/updateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ���ձ�����
        String id = request.getParameter("id");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String hiredate = request.getParameter("hiredate");
        String sal = request.getParameter("sal");
        UserService userService = new UserServiceImpl();
        // �ȸ���id��ѯ����ѯ�����ݿ��д��ڵ��û�
        Employee emp = userService.findEmpById(Integer.valueOf(id));
        // ����һ��Ҫ�޸ĵ�Ա������
        Employee emp1 = new Employee();
        emp1.setId(emp.getId());

        // �жϱ��ύ�������Ƿ�Ϊ�գ����Ϊ�գ���ʾ�����޸ģ����Ѵ����ݿ��ѯ��ename��emp1
        // �����Ϊ�գ���ʾҪ�޸ģ���ֱ�Ӱ�ename��ֵ��emp1
        if (ename == null || "".equals(ename)) {
            emp1.setEname(emp.getEname());
        }else {
            emp1.setEname(ename);
        }

        // �жϱ��ύ�������Ƿ�Ϊ�գ����Ϊ�գ���ʾ�����޸ģ����Ѵ����ݿ��ѯ��job��emp1
        // �����Ϊ�գ���ʾҪ�޸ģ���ֱ�Ӱ�job��ֵ��emp1
        if (job == null || "".equals(job)) {
            emp1.setJob(emp.getJob());
        }else {
            emp1.setJob(job);
        }

        // �жϱ��ύ�������Ƿ�Ϊ�գ����Ϊ�գ���ʾ�����޸ģ����Ѵ����ݿ��ѯ��hiredate��emp1
        // �����Ϊ�գ���ʾҪ�޸ģ���ֱ�Ӱ�hiredate��ֵ��emp1
        if (hiredate == null || "".equals(hiredate)) {
            emp1.setHiredate(emp.getHiredate());
        }else {
            emp1.setHiredate(Date.valueOf(hiredate));
        }

        // �жϱ��ύ�������Ƿ�Ϊ�գ����Ϊ�գ���ʾ�����޸ģ����Ѵ����ݿ��ѯ��sal��emp1
        // �����Ϊ�գ���ʾҪ�޸ģ���ֱ�Ӱ�sal��ֵ��emp1
        if (sal == null || "".equals(sal)) {
            emp1.setSal(emp.getSal());
        }else {
            emp1.setSal(Double.valueOf(sal));
        }

        // ����service���޸�Ա���ķ���
        userService.updateEmp(emp1);
        // request.getContextPath()��ȡ��Ŀ��Ŀ¼
        response.getWriter().println("<h1>�޸ĳɹ�</h1><a href='"+request.getContextPath()+"/findAllEmpServlet'><font color='red'>��ѯ����Ա����Ϣ����������...</font></a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
