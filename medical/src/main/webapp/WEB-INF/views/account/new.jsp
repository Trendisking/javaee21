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
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="dept-list.html"> 系统账户列表</a>  /  新增账号
            </span>
                </div>
                <div class="box-body form">
                    <form action="" method="post">
                        <label>员工姓名</label>
                        <input type="text" id="name">
                        <label>账号 <span class="muted">(用于登录系统)</span></label>
                        <input type="text" id="account">
                        <label>密码 <span class="muted">(默认123456)</span></label>
                        <input type="password" value="123456">
                        <label>联系电话</label>
                        <input type="text">
                        <label>请选择角色</label>
                        <select name="" id="">
                            <option value="">管理员</option>
                            <option value="">普通员工</option>
                        </select>

                        <div class="form-actions">
                            <button class="button button-flat-action button-pill">保存</button>
                        </div>
                    </form>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>


</body>
</html>