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
        <li><a href="#">修改岗位信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <%
        String posid = request.getParameter("posid");
        String pname = request.getParameter("pname");
        String pdesc = request.getParameter("pdesc");
    %>
    <form action="updatePosition" method="post">
        <ul class="forminfo">
            <li><label>岗位编号</label><input name="posid" type="text" class="dfinput" value="<%=posid%>"
                                          disabled="disabled"/>
            </li>
            <%--hidden类型用来提交数据不会显示在页面上--%>
            <input name="posid" type="hidden" value="<%=posid%>"/>
            <li><label>岗位名称</label><input name="pname" type="text" class="dfinput" value="<%=pname%>"/></li>
            <li><label>岗位描述</label><input name="pdesc" type="text" class="dfinput" value="<%=pdesc%>"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>


</body>

</html>

