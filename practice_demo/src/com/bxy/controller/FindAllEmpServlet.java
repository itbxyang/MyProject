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
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ����ѯ����Ա����Ϣ��servlet��controller�㷽����
 *
 */
@WebServlet("/findAllEmpServlet")
public class FindAllEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ����һ��service��ӿ�ʵ������󲢸�ֵ���ӿ�
        UserService userService = new UserServiceImpl();
        // ����service�� ��ѯ����Ա���ķ���
        List<Employee> allEmp = userService.findAllEmp();
        // �Ѳ�ѯ������Ա��������ӵ�request����
        request.setAttribute("allEmp",allEmp);
        // ��ת��listҳ��
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
