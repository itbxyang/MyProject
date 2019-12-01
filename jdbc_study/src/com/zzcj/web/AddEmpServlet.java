package com.zzcj.web;

import com.zzcj.dao.EmpDao;
import com.zzcj.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addEmpServlet")
public class AddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收表单数据
        String id = request.getParameter("id");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String hiredate = request.getParameter("hiredate");
        String sal = request.getParameter("sal");
        // 创建一个要添加的对象
        Emp emp = new Emp(Integer.valueOf(id), ename, job, Date.valueOf(hiredate), Double.valueOf(sal));
        EmpDao empDao = new EmpDao();
        // 调用添加员工的方法
        empDao.addEmp(emp);
        // request.getContextPath()获取项目根目录
        response.getWriter().println("<h1>添加成功</h1><a href='"+request.getContextPath()+"/findAllEmpServlet'><font color='red'>查询所有员工信息，请点击这里...</font></a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
