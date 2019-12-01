package cn.zzcj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/loginProcessServelt")
public class LoginProcessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        request.setCharacterEncoding("utf-8");
        // 获取表单提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 用cookie保存编码后的username
        Cookie cookie = new Cookie("username", URLEncoder.encode(username, "utf-8"));
        // 设置cookie的存活时间(以秒为单位)
        cookie.setMaxAge(60*5);
        // 往浏览器保存cookie
        response.addCookie(cookie);
        // 判断是否登录成功
        if (password != null && !"".equals(password) && password.contains("javaweb")) {
            // 获取session
            HttpSession session = request.getSession();
            // 把用户名添加到session
            session.setAttribute("username", username);
            // 跳转到成功页面
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }else {
            request.setAttribute("msg", "用户名或密码错误！！！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
