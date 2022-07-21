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

            function show(){
                history.back();
            }
        </script>

    </head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">报销管理</a></li>
        <li><a href="#">查看具体报销项</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="formtitle1"><span>具体报销项</span></div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>
                <input name="" type="checkbox" value="" checked="checked" />
            </th>
            <th>报销项编号<i class="sort"><img src="images/px.gif" /></i></th>
            <th>报销项类型</th>
            <th>报销项金额</th>
            <th>报销项说明</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${expenseitems}" var="expitem">
            <tr>
                <td>
                    <input name="" type="checkbox" value="" />
                </td>
                <td>${expitem.itemid}</td>
                <c:if test="${expitem.type =='1'}">
                    <td>通信费用</td>
                </c:if>
                <c:if test="${expitem.type =='2'}">
                    <td>办公室耗材</td>
                </c:if>
                <c:if test="${expitem.type =='3'}">
                    <td>住宿费用</td>
                </c:if>
                <c:if test="${expitem.type =='4'}">
                    <td>房租水电</td>
                </c:if>
                <c:if test="${expitem.type =='5'}">
                    <td>其他</td>
                </c:if>
                <td>${expitem.amount}</td>
                <td>${expitem.itemdesc}</td>

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
