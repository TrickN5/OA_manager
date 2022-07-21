<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2022/6/21
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });

        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">员工信息详情</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <ul class="forminfo">
        <li>
            <label>用户名</label>
            <label>${param.empid}</label>
        </li>
        <li>
        <li>
            <label>真实姓名</label>
            <label>${param.realname}</label>
        </li>
        <li>
            <label>性别</label>
            <label>${param.sex}</label>
        </li>
        <li>
            <label>出生日期</label>
            <label>${param.sBirthdate}</label>
        </li>
        <li>
        <li>
            <label>入职时间</label>
            <label>${param.sHiredate}</label>
        </li>

        <li>
            <label>离职时间</label>
            <label>${param.sLeavedate}</label>
        </li>
        <li>
            <label>是否在职</label>
            <label>${param.onduty==1?"在职":"离职"}</label>
        </li>
        <li>
            <label>所属部门<b>*</b></label>
            <label>${param.deptname}</label>

        </li>
        <li>
            <label>直接上级<b>*</b></label>
            <label>${param.mgrname}<b>*</b></label>
        </li>
        </li>
        <li>
            <label>联系方式</label>
            <label>${param.phone}</label>
        </li>
        <li>
            <label>QQ号</label>
            <label>${param.qq}</label>
        </li>
        <li>
            <label>紧急联系人信息</label>
            <label>${param.emercontactperson}</label>
        </li>
        <li>
            <label>身份证号</label>
            <label>${param.idcard}</label>
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="button" class="btn" value="返回"/>
        </li>
    </ul>

</div>

</body>

</html>
