<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取当前工程的根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>"> <!--这个让此文件下的路径都相对于当前工程开始-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
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
    <form action="loginUser" method="post">
        <div class="loginbox loginbox2">
            <ul>
                <li><input name="empid" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/>
                </li>
                <li><input name="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/>
                </li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码"
                                 onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>

                </li>
                <font color="red">${msg}</font>
                <a href="smslogin">短信登录</a>
                <li><input name="" type="submit" class="loginbtn" value="登录"/><label><input name="" type="checkbox"
                                                                                            value="" checked="checked"/>记住密码</label><label><a
                        href="#">忘记密码？</a></label></li>
            </ul>
        </div>
    </form>

</div>


</body>

</html>
