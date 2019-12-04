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
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个修改员工信息的servlet（controller层方法）
 *
 */
@WebServlet("/updateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收表单数据
        String id = request.getParameter("id");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String hiredate = request.getParameter("hiredate");
        String sal = request.getParameter("sal");
        UserService userService = new UserServiceImpl();
        // 先根据id查询出查询出数据库中存在的用户
        Employee emp = userService.findEmpById(Integer.valueOf(id));
        // 创建一个要修改的员工对象
        Employee emp1 = new Employee();
        emp1.setId(emp.getId());

        // 判断表单提交的数据是否为空，如果为空（表示不用修改），把从数据库查询的ename给emp1
        // 如果不为空（表示要修改），直接把ename赋值给emp1
        if (ename == null || "".equals(ename)) {
            emp1.setEname(emp.getEname());
        }else {
            emp1.setEname(ename);
        }

        // 判断表单提交的数据是否为空，如果为空（表示不用修改），把从数据库查询的job给emp1
        // 如果不为空（表示要修改），直接把job赋值给emp1
        if (job == null || "".equals(job)) {
            emp1.setJob(emp.getJob());
        }else {
            emp1.setJob(job);
        }

        // 判断表单提交的数据是否为空，如果为空（表示不用修改），把从数据库查询的hiredate给emp1
        // 如果不为空（表示要修改），直接把hiredate赋值给emp1
        if (hiredate == null || "".equals(hiredate)) {
            emp1.setHiredate(emp.getHiredate());
        }else {
            emp1.setHiredate(Date.valueOf(hiredate));
        }

        // 判断表单提交的数据是否为空，如果为空（表示不用修改），把从数据库查询的sal给emp1
        // 如果不为空（表示要修改），直接把sal赋值给emp1
        if (sal == null || "".equals(sal)) {
            emp1.setSal(emp.getSal());
        }else {
            emp1.setSal(Double.valueOf(sal));
        }

        // 调用service层修改员工的方法
        userService.updateEmp(emp1);
        // request.getContextPath()获取项目根目录
        response.getWriter().println("<h1>修改成功</h1><a href='"+request.getContextPath()+"/findAllEmpServlet'><font color='red'>查询所有员工信息，请点击这里...</font></a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
