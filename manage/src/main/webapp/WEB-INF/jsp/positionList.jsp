<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath(); //获取当前工程的根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>"> <!--这个让此文件下的路径都相对于当前工程开始-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">岗位管理</a></li>
    </ul>
</div>

<div class="rightinfo">


    <div class="formtitle1"><span>岗位列表</span></div>

    <table class="tablelist" >
        <thead>

        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>岗位编号<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>岗位名称</th>
            <th>岗位描述</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${positions}" var="position">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${position.posid}</td>
                <td>${position.pname}</td>
                <td>${position.pdesc}</td>
                <td><a href="positionUpdate?posid=${position.posid}&pname=${position.pname}&pdesc=${position.pdesc}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deletePosition/${position.posid}" class="tablelink click"> 删除</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>



    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="../images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>
    <div class="pagin">
        <div class="message">共<i class="blue">${total}</i>条记录，当前显示第&nbsp;<i class="blue">${pageNum}&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="dumpToPrep"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="dumpTop/1">1</a></li>
            <li class="paginItem"><a href="dumpTop/2">2</a></li>
            <li class="paginItem"><a href="dumpTop/3">3</a></li>
            <li class="paginItem"><a href="dumpTop/4">4</a></li>
            <li class="paginItem"><a href="dumpTop/5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="dumpTop/10">10</a></li>
            <li class="paginItem"><a href="dumpToNextp"><span class="pagenxt"></span></a></li>
        </ul>
    </div>



</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>
</html>
