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
    <jsp:param name="menu" value="role"/>
</jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="role-list.html"> 角色列表</a>  /  新增角色
            </span>
                </div>
                <div class="box-body form">
                    <form action="" method="post">
                        <label>角色名称</label>
                        <input type="text">
                        <label>病人档案权限</label>
                        <div style="padding-left:50px;margin-bottom:20px">
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 浏览
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox2" value="option2"> 搜索
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 新建
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 修改
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 删除
                            </label>
                        </div>
                        <label>就诊记录权限</label>
                        <div style="padding-left:50px;margin-bottom:20px">
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 浏览
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox2" value="option2"> 搜索
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 新建
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 修改
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 删除
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox3" value="option3"> 导出
                            </label>
                        </div>
                        <label>复诊提醒权限</label>
                        <div style="padding-left:50px;margin-bottom:20px">
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 浏览
                            </label>
                        </div>
                        <label>数据统计权限</label>
                        <div style="padding-left:50px;margin-bottom:20px">
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 浏览
                            </label>
                        </div>
                        <label>系统设置权限</label>
                        <div style="padding-left:50px;margin-bottom:20px">
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 浏览
                            </label>
                            <label class="checkbox inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> ...
                            </label>
                        </div>
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