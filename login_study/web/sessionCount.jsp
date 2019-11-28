<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计在线人数</title>
</head>
<body>
<%!
    Integer num = 0;
%>
<%
    if (session.isNew()) {
        ++num;
        session.setAttribute("count",num);
    }
%>
<h1>you are the <font color="red"><%=session.getAttribute("count")%></font> person!</h1>
</body>
</html>
