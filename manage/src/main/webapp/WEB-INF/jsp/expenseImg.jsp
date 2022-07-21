<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".click").click(function() {
                $(".tip").fadeIn(200);
            });
            $(".tiptop a").click(function() {
                $(".tip").fadeOut(200);
            });
            $(".sure").click(function() {
                $(".tip").fadeOut(100);
            });
            $(".cancel").click(function() {
                $(".tip").fadeOut(100);
            });
        });

        function show() {
            history.back();
        }
    </script>

</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">报销管理</a></li>
        <li><a href="#">查看所附图片</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="formtitle1"><span>查看所附图片</span></div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${images}" var="image">
            <tr>
                <td><img src="${image.filename}"></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<input name="" type="button" class="btn" value="返回" onclick="show()"/>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
