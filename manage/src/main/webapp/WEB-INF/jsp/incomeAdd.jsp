<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2022/7/20
  Time: 21:34
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
        <li><a href="#">收支管理</a></li>
        <li><a href="#">添加收入</a></li>
    </ul>
</div>

<div class="formbody">
    <form action="addIncome" method="post">
        <div class="formtitle"><span>基本信息</span></div>

        <ul class="forminfo">
            <li>
                <label>所属部门<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="deptno">
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.deptno}">${dept.deptname}</option>
                        </c:forEach>
                    </select>
                </div>

            </li>
            <li>
                <label>收入金额</label>
                <input name="amount" type="text" class="dfinput"/><i></i></li>
            <li>
                <label>收入类型</label>
                <cite>
                    <input name="indesc" type="radio" value="" checked="checked"/>人员外包&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="indesc" type="radio" value=""/>项目开发&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="indesc" type="radio" value=""/>技术咨询费&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="indesc" type="radio" value=""/>房租收入&nbsp;&nbsp;&nbsp;&nbsp;
                </cite>
            </li>
            <li>
                <label>收入日期</label>
                <input name="birthdate" type="text" class="dfinput" onfocus="WdatePicker({skin:'whyGreen',lang:'en'})"/>
            </li>
            <li>
                <label>备注</label>
                <textarea name="" cols="" rows="" class="textinput"></textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" class="btn" value="确认保存"/>
            </li>
        </ul>
    </form>
</div>

</body>

</html>
