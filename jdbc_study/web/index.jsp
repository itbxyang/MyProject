<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h2><a href="/jdbc/findAllEmpServlet">查询所有员工信息</a></h2>

  <hr color="red">
  <h2>添加员工信息</h2>
  <form action="/jdbc/addEmpServlet" method="post">
    <p>
      <input type="text" name="id" placeholder="请输入员工编号">
    </p>
    <p>
    <input type="text" name="ename" placeholder="请输入员工姓名">
    </p>
    <p>
      <input type="text" name="job" placeholder="请输入员工职位">
    </p>
    <p>
      <input type="date" name="hiredate" placeholder="请输入入职日期">
    </p>
    <p>
      <input type="text" name="sal" placeholder="请输入员工薪资">
    </p>
    <p>
      <input type="submit" value="添加">
    </p>
  </form>


  <hr color="red">
  <h2>修改员工信息</h2>
  <form action="/jdbc/updateEmpServlet" method="post">
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

  <hr color="red">
  <h2>删除员工信息</h2>
  <form action="/jdbc/delEmpServlet" method="post">
    <p>
      <input type="text" name="id" placeholder="请输入您要删除的员工编号">&nbsp;&nbsp;<input type="submit" value="删除">
    </p>
  </form>
  </body>
</html>
