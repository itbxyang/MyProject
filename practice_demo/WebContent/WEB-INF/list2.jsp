<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>信息详情</title>
    <%pageContext.setAttribute("path", request.getContextPath());%>
    <!-- Bootstrap -->
    <link href="${path}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${path}/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${path}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align="center"><font style="font-family: 楷体">所有员工信息</font></h1>

<table  class="table table-striped">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>职位</th>
        <th>受聘日期</th>
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
