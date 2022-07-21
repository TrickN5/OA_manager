<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });

        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">修改员工信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="updateEmp">
        <ul class="forminfo">
            <li>
                <label>用户名</label>
                <input name="empid" type="text" class="dfinput" value="${emp.empid}" disabled="disabled"/><i>必须唯一，也可以根据真实姓名自动生成</i></li>
            <input type="hidden" name="empid" value="${emp.empid}"/>
            <li>
            <li>
                <label>真实姓名</label>
                <input name="realname" type="text" class="dfinput" value="${emp.realname}"/><i></i></li>
            <li>
                <label>性别</label><cite>
                <c:if test="${emp.sex =='男'}">
                <input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="sex" type="radio" value="女" />女</cite>
                </c:if>
                <c:if test="${emp.sex =='女'}">
                    <input name="sex" type="radio" value="男" />男&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="sex" type="radio" value="女" checked="checked" />女</cite>
                </c:if>

            </li>
            <li>
                <label>出生日期</label>
                <input name="birthdate" type="text" class="dfinput" value="${emp.sBirthdate}"/></li>
            <li>
            <li>
                <label>入职时间</label>
                <input name="hiredate" type="text" class="dfinput"  value="${emp.sHiredate}"/><i></i></li>

            <li>
                <label>离职时间</label>
                <input name="leavedate" type="text" class="dfinput" value="${emp.sLeavedate}"/><i></i></li>
            <li>
                <label>是否在职</label><cite>
                <c:if test="${emp.onduty ==1}">
                <input name="onduty" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="onduty" type="radio" value="0" />否</cite>
                </c:if>
                <c:if test="${emp.onduty != 1}">
                    <input name="onduty" type="radio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="onduty" type="radio" value="0" checked="checked" />否</cite>
                </c:if>
            </li>
            <li>
                <label>所属部门<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="deptno">
                        <c:forEach items="${depts}" var="dept">
                            <c:if test="${dept.deptno ==emp.deptno}">
                                <option value="${dept.deptno}" selected="selected">${dept.deptname}</option>
                            </c:if>
                            <c:if test="${dept.deptno !=emp.deptno}">
                                <option value="${dept.deptno}">${dept.deptname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

            </li>
            <li>
                <label>直接上级<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="mgrid">
                        <c:forEach items="${mgrs}" var="mgr">
                            <%--在遍历的时候,遍历到所有的上级id刚好是当前员工的上级id,则让这个值被选中--%>
                            <c:if test="${mgr.empid == emp.mgrid}">
                                <option value="${mgr.empid}" selected="selected">${mgr.realname}</option>
                            </c:if>
                            <c:if test="${mgr.empid != emp.mgrid}">
                                <option value="${mgr.empid}">${mgr.realname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </li>
            <li>
                <label>联系方式</label>
                <input name="phone" type="text" class="dfinput" value="${emp.phone}"/>
            </li>
            <li>
                <label>QQ号</label>
                <input name="qq" type="text" class="dfinput" value="${emp.qq}"/>
            </li>
            <li>
                <label>紧急联系人信息</label>
                <textarea name="emercontactperson" cols="" rows="" class="textinput" >${emp.emercontactperson}</textarea>
            </li>
            <li>
                <label>身份证号</label>
                <input name="idcard" type="text" class="dfinput" value="${emp.idcard}"/>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" class="btn" value="确认保存" />
            </li>
        </ul>
    </form>
</div>

</body>

</html>