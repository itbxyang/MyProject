package com.zzcj.web;

import com.zzcj.dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delEmpServlet")
public class DelEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收表单数据
        String id = request.getParameter("id");
        EmpDao empDao = new EmpDao();
        // 调用删除员工的方法
        empDao.delEmp(Integer.valueOf(id));
        // request.getContextPath()获取项目根目录
        response.getWriter().println("<h1>删除成功</h1><a href='"+request.getContextPath()+"/findAllEmpServlet'><font color='red'>查询所有员工信息，请点击这里...</font></a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
