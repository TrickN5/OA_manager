<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="js/jquery.js"></script>
    <script>
        function signIn(){
            //发送ajax请求签到
            $.get("signIn",function (data) {
                if(data =="1"){
                    $("#signinspan").html("签到成功");
                }else if(data =="2"){
                    $("#signinspan").html("已经签过了");
                }else{
                    $("#signinspan").html("签到失败");
                }

            })
        }
        function signOut(){
            //发送ajax请求签到
            $.get("signOut",function (data) {
                if(data =="1"){
                    $("#signoutspan").html("签退成功");
                }else{
                    $("#signoutspan").html("签到失败");
                }

            })
        }


    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">考勤管理</a></li>
        <li><a href="#">签到签退</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="签到" onclick="signIn()"/> <span id="signinspan"></span></li>
        <li><label>&nbsp;</label></li>
        <li><label>&nbsp;</label></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="签退" onclick="signOut()"/><span id="signoutspan"></span></li>
    </ul>


</div>


</body>

</html>

