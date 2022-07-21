<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2022/6/14
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">修改部门信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <%
        String deptno = request.getParameter("deptno");
        String deptname = request.getParameter("deptname");
        String location = request.getParameter("location");
    %>
    <form action="updateDept" method="post">
        <ul class="forminfo">
            <li><label>部门编号</label><input name="deptno" type="text" class="dfinput" value="<%=deptno%>"
                                          disabled="disabled"/>
            </li>
            <%--hidden类型用来提交数据不会显示在页面上--%>
            <input name="deptno" type="hidden" value="<%=deptno%>"/>
            <li><label>部门名称</label><input name="deptname" type="text" class="dfinput" value="<%=deptname%>"/></li>
            <li><label>办公地点</label><input name="location" type="text" class="dfinput" value="<%=location%>"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>


</body>

</html>

