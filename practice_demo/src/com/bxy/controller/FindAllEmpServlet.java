package com.bxy.controller;

import com.bxy.domain.Employee;
import com.bxy.service.UserService;
import com.bxy.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个查询所有员工信息的servlet（controller层方法）
 *
 */
@WebServlet("/findAllEmpServlet")
public class FindAllEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 创建一个service层接口实现类对象并赋值给接口
        UserService userService = new UserServiceImpl();
        // 调用service层 查询所有员工的方法
        List<Employee> allEmp = userService.findAllEmp();
        // 把查询出来的员工集合添加到request域中
        request.setAttribute("allEmp",allEmp);
        // 跳转到list页面
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
