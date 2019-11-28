<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计网站访问量</title>
</head>
<body>
<%
    Integer count = (Integer) application.getAttribute("count");
    if (count == null) {
        count = 1;
    }else {
        ++count;
    }
    application.setAttribute("count",count);
    response.getWriter().println("<h1>本网站访问量是：<font color='red'>"+count+"</font></h1>");
%>

</body>
</html>
