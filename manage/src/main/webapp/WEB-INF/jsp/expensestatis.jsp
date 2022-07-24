<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>

<script src="js/jquery.js"></script>
<script type="text/javascript" src="https://fastly.jsdelivr.net/npm/echarts@5.3.3/dist/echarts.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.get("getPayDatas", function (data) {
            eval("var datas =" + data);
            var dom = document.getElementById('container');
            var myChart = echarts.init(dom, null, {
                renderer: 'canvas',
                useDirtyRect: false
            });
            var app = {};

            var option;

            option = {
                title: {
                    text: '企业支出统计表',
                    subtext: '来自于财务部',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '50%',
                        data: datas,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            if (option && typeof option === 'object') {
                myChart.setOption(option);
            }

            window.addEventListener('resize', myChart.resize);
        })
    })
</script>
</body>
</html>