<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成功页面</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    // 从session获取username的值
    String username = (String)session.getAttribute("username");
    // 如果为空，把验证信息添加到rquest域，跳转到login首页
    if (username==null) {
        request.setAttribute("msg", "您还尚未登录，请登录！！！");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>

<h1>欢迎<font color="red">${username}</font>登录</h1>
</body>
</html>
