<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息详情</title>
</head>
<body>
<h1 align="center">所有员工信息</h1>

<table width="900px" align="center" border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>工作</th>
        <th>入职日期</th>
        <th>薪资</th>
    </tr>
    <c:forEach items="${allEmp}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
