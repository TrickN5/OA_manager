<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>审核报销单</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        function submitForm(){
            window.close();

        }
        $(function () {
            var results = $("input[name='result']");//获取三个单选按钮对象,是个数组
            var result;//接收被选中单选按钮的value值
            $("#but").click(function () {
                //获取被选中的单选按钮的值
                for(var i=0;i<results.length;i++){
                    var flag = results[i].checked;//布尔值
                    if(flag){
                        result = results[i].value;
                    }
                }
                //发送ajax请求
                $.get("exp/auditing", {"expid":${param.expid}, "result":result, "auditdesc":$("input[name='auditdesc']").val(),
                    },
                    function (data) {
                        if("success"==data){
                            //跳转到
                            history.back();
                            window.close();//关闭小窗口
                        }else{
                            alert("失败!")
                        }
                    }
                )

            })
        })


    </script>
</head>

<body>

<div class="formtitle"><span>审核报销单</span></div>
<form action="#" onsubmit="return submitForm()">
    <ul class="forminfo">

        <li>
            <label>审核结果</label>
            <input name="result" type="radio" value="1"/>通过
            <input name="result" type="radio" value="2"/>拒绝
            <input name="result" type="radio" value="3"/>打回
        </li>
        <li>
            <label>审核意见</label>
            <input name="auditdesc" type="text" class="dfinput" />
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="button" class="btn" value="确认审核" id="but" />
        </li>
    </ul>
</form>
</body>

</html>
