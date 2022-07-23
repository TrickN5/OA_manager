<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取当前工程的根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>"> <!--这个让此文件下的路径都相对于当前工程开始-->
    <title>Title</title>
</head>
<body style="height: 100%; margin: 0">
<div >
    <h1 align="center">公司收入统计柱状图</h1>
</div>
<div id="container" style="height: 90%"></div>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>

<script type="text/javascript">
    //页面加载事件
    $(function () {
        //发送ajax请求后台取数据(axios发送http请求后台)
        $.get("getIncomeDatas",function (data) {
            // eval("var a =你好"); // 可以转成 var a ="你好"
            // eval("var date = new date()"); // 可以转成 var date = new date()
            // var datas = [['周一', '周二', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],[1900, 2000, 1500, 800, 700, 1010, 1030]]
            eval("var datas =" + data);  //eval()函数可以把字符串转成对应的数据类型
            var dom = document.getElementById("container");
            var myChart = echarts.init(dom);
            var app = {};
            var option;
            option = {
                xAxis: {
                    type: 'category',
                    data: datas[0]
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: datas[1],
                        type: 'bar'
                    }
                ]
            };

            if (option && typeof option === 'object') {
                myChart.setOption(option);
            }
        })
    })
</script>
</body>
</html>
