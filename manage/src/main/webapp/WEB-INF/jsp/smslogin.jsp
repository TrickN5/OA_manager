<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
            //发送短信
            $("#sendsms").click(function () {
                var phone = $("#phone").val();
                $.get(
                    "smsSend",
                    {"phone":phone},
                    function (data) {
                        var n = data;
                        if(n==1){
                            $("#spansms").html("短信发送成功!")
                        }else{
                            $("#spansms").html("此手机号码没有注册,请先注册!")
                        }
                    }
                )
            })
        });
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎访问OA协同办公管理系统</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox loginbox2">
        <form action="smsLogin">

            <ul>
                <li>
                    <input name="phone" type="text" class="loginuser" value="${phone}" onclick="JavaScript:this.value=''" placeholder="请输入手机号" id="phone"/>
                    <a href="javascript:void(0)"  id="sendsms">发送短信</a></li>
                <li>
                <span id="spansms">${msg}</span>
                </li>
                <li class="yzm">
                    <span><input name="code" type="text" placeholder="输入短信验证码"/></span>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="短信登录"/>
            </ul>
        </form>


    </div>

</div>





</body>

</html>

