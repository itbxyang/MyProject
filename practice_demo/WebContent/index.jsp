<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%--${pageContext.request.contextPath}:指的是利用软编码的方式获取项目的根目录--%>
  <h2><a href="${pageContext.request.contextPath}/findAllEmpServlet">点击查询所有员工信息</a></h2>


  <hr color="red">
  <h1><font color="blue">修改员工信息</font></h1>
  <h5><font color="red">声明：编号必须填写，其他修改字段可填可不填（不填代表不修改，与原来的数据保持一致）</font></h5>
  <%--${pageContext.request.contextPath}:指的是利用软编码的方式获取项目的根目录--%>
  <form action="${pageContext.request.contextPath}/updateEmpServlet" method="post">
    <p>
      <input type="text" name="id" placeholder="请输入您要修改的员工编号(必须填)">
    </p>
    <p>
      <input type="text" name="ename" placeholder="请输入要修改的员工姓名">
    </p>
    <p>
      <input type="text" name="job" placeholder="请输入要修改的员工职位">
    </p>
    <p>
      <input type="date" name="hiredate" placeholder="请输入要修改的入职日期">
    </p>
    <p>
      <input type="text" name="sal" placeholder="请输入要修改的员工薪资">
    </p>
    <p>
      <input type="submit" value="修改">
    </p>
  </form>

  </body>
</html>
