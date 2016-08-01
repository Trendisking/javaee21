<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/js/rangepicker/style.css">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>

<jsp:include page="../include/leftSidebar.jsp">
    <jsp:param name="menu" value="chart"/>
</jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-bar-chart-o"></i> 疾病统计</span>
                </div>
                <div class="box-body form">
                    <label>选择统计时间段</label>
                    <input type="text" id="rangepicker">
                    <br/>
                    <canvas id="myChart" width="900" height="400"></canvas>
                </div>
            </div>


        </div>
    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="http://cdn.staticfile.org/Chart.js/0.2.0/Chart.min.js"></script>
<script src="/static/js/moment.min.js"></script>
<script src="/static/js/rangepicker/rangepicker.js"></script>
<script>
    $(function(){


        //初始化值
        var data = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    fillColor: "#40d47e",
                    strokeColor: "rgba(220,220,220,0.8)",
                    highlightFill: "rgba(220,220,220,0.75)",
                    highlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 140]
                }
            ]
        };
        var ctx = $("#myChart").get(0).getContext("2d");
        new Chart(ctx).Bar(data);
        $("#rangepicker").daterangepicker(
                {
                    ranges: {
                        '今天': [new Date(), new Date()],
                        '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
                        '最近7天': [moment().subtract('days', 6), new Date()],
                        '最近30天': [moment().subtract('days', 29), new Date()],
                        '本月': [moment().startOf('month'), moment().endOf('month')],
                        '上一月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                    },
                    opens: 'left',
                    format:'YYYY/MM/DD'
                }


        );




    });
</script>

</body>
</html>