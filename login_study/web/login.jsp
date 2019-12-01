<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录首页</title>
</head>
<body>


<%
  // 获取cookie
  Cookie cs[] = request.getCookies();
  String value = "";
  // 先判断cookie是否为空，然后遍历cookie
  if (cs != null) {
    for (Cookie c:cs) {
      String username = c.getName();
      if ("username".equals(username)) {
        // 解码cookie存入username的值
        value= URLDecoder.decode(c.getValue(),"utf-8");
      }
    }
  }

  // 获取登录验证的信息
  String msg = (String)request.getAttribute("msg");
  if (msg==null) {
    msg="";
  }
%>
<h3><font color="red"><%=msg %></font></h3>
<%--${pageContext.request.contextPath}:指的是利用软编码的方式获取项目的根目录--%>
<form action="${pageContext.request.contextPath}/loginProcessServelt" method="post">
  用户名：<input type="text" name="username" value=<%=value %>><br>
  密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
  <input type="submit" value="登录">
</form>
</body>
</html>
