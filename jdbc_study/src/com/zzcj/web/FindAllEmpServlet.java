package com.zzcj.web;

import com.zzcj.dao.EmpDao;
import com.zzcj.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/findAllEmpServlet")
public class FindAllEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao empDao = new EmpDao();
        // 调用查询所有员工的方法
        List<Emp> allEmp = empDao.findAllEmp();
        // 把查询出来的员工集合添加到request域中
        request.setAttribute("allEmp",allEmp);
        // 跳转到list页面
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
