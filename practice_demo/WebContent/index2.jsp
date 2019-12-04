<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>
    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  <body>
  <%--${pageContext.request.contextPath}:指的是利用软编码的方式获取项目的根目录--%>
  <h2><a href="${pageContext.request.contextPath}/findAllEmpServlet"><font style="font-family: 楷体">点击查询所有员工信息</font></a></h2>


  <hr color="red">
  <h1 align="center"><font color="blue" style="font-family: 楷体">修改员工信息</font></h1>
  <h5 align="right"><font color="red"  style="font-family: 楷体">声明：编号必须填写，其他修改字段可填可不填（不填代表不修改，与原来的数据保持一致）</font></h5><br><br>
  <%--${pageContext.request.contextPath}:指的是利用软编码的方式获取项目的根目录--%>
  <form action="${pageContext.request.contextPath}/updateEmpServlet" method="post" class="form-horizontal">
  	<div class="form-group">
	    <label for="id" class="col-sm-2 control-label">编号</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" id="id" name="id" placeholder="请输入您要修改的员工编号（必须填）">
	    </div>
  	</div>
  	<div class="form-group">
	    <label for="ename" class="col-sm-2 control-label">姓名</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" id="ename" name="ename" placeholder="请输入要修改的员工姓名">
	    </div>
  	</div>
  	<div class="form-group">
	    <label for="job" class="col-sm-2 control-label">职位</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" id="job" name="job" placeholder="请输入要修改的员工职位">
	    </div>
  	</div>
  	<div class="form-group">
	    <label for="hiredate" class="col-sm-2 control-label">受聘日期</label>
	    <div class="col-sm-7">
	      <input type="date" class="form-control" id="hiredate" name="hiredate" placeholder="请输入要修改的受聘日期">
	    </div>
  	</div>
  	<div class="form-group">
	    <label for="sal" class="col-sm-2 control-label">薪资</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" id="sal" name="sal" placeholder="请输入要修改的员工薪资">
	    </div>
  	</div>
  	
  	
    <p>
      &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
      <input type="submit" class="btn btn-success" value="点击修改">
    </p>
  </form>

  </body>
</html>
