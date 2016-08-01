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
    <jsp:param name="menu" value="notify"/>
</jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-search"></i> 搜索</span>
                </div>
                <div class="box-body search-box">
                    <form action="" class="form-search">
                        <input type="text" id="rangepicker" placeholder="就诊时间">
                        <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
                    </form>
                </div>
            </div>




            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-bell-o"></i> 提醒列表</span>

                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="100">复诊时间</th>
                            <th width="100">姓名</th>
                            <th width="100">联系电话</th>
                            <th width="50">性别</th>
                            <th width="150">科室</th>
                            <th width="200">病种</th>
                            <th>初步诊断</th>
                            <th width="50">状态</th>
                            <th width="100">创建日期</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td></td>
                            <td><a href="patient.html"></a></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/rangepicker/rangepicker.js"></script>
<script>
    $(function(){

        $("#rangepicker").daterangepicker(
                {
                    ranges: {
                        '3天内': [new Date(),moment().subtract('days', -3)],
                        '7天内': [new Date(),moment().subtract('days', -6)]
                    },
                    opens: 'right',
                    format:'YYYY/MM/DD'
                },
                function(start,end,label){
                    console.log("start:" + start.format('YYYY-MM-DD'));
                    console.log("end:" + end.format('YYYY-MM-DD'));
                }

        );




    });
</script>

</body>
</html>