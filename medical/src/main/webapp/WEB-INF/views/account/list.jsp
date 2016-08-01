<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>

<jsp:include page="../include/leftSidebar.jsp">
    <jsp:param name="menu" value="account"/>
</jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-user-md"></i> 系统账号列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/account/new"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">账户名称</th>
                            <th width="200">员工姓名</th>
                            <th>电话</th>
                            <th>最后登录时间</th>
                            <th>最后登录IP</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>zhangxiaoming</td>
                            <td>张晓明</td>
                            <td>18999999999</td>
                            <td>2014-07-09 12:34</td>
                            <td>192.168.0.98</td>
                            <td>
                                <a href="">修改</a>
                                <a href="">禁用</a>
                                <a href="#">删除</a>
                            </td>
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

</body>
</html>