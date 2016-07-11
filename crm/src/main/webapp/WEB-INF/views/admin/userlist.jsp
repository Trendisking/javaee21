<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>英雄录</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">

    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">

    <link rel="stylesheet" href="/static/plugins/datatables/css/dataTables.bootstrap.min.css">

    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <%@include file="../include/leftSidebar.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
               英雄管理
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">英雄列表</h3>
                    <div class="box-tools pull-right" >
                        <a href="javascript:;" id="newBtn" class="btn btn-xs btn-success"><i class="fa fa-plus"></i> 新增</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table" id="userTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>账号</th>
                            <th>英雄姓名</th>
                            <th>微信号</th>
                            <th>角色</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody></tbody>

                    </table>
                </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<div class="modal fade" id="newModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增用户</h4>
            </div>
            <div class="modal-body">
                <form id="newForm">
                    <div class="form-group">
                        <label>账号(用于系统登录)</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="form-group">
                        <label>英雄姓名(真实姓名)</label>
                        <input type="text" class="form-control" name="realname">
                    </div>
                    <div class="form-group">
                        <label>密码(默认 000000)</label>
                        <input type="text" class="form-control" name="password" value="000000">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin">
                    </div>
                    <div class="form-group">
                        <label>角色</label>
                        <select class="form-control" name="roleid">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${role.id}">${role.rolename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>

<script>
    $(function(){
        var dataTable=$("#userTable").DataTable({
            serverSide:true,
            ajax:"/admin/users/load",
            ordering:false,
            "autoWidth":false,
            columns:[
                {"data":"id"},
                {"data":"username"},
                {"data":"realname"},
                {"data":"weixin"},
                {"data":"role.rolename"},
                {"data":function(row){
                    if(row.enable){
                        return "<span class='label label-success'>正常</span>";
                    }else{
                        return "<span class='label label-danger'>禁用</span>";
                    }
                }},
                {"data":function(row){
                    var timestamp=row.createtime;
                    var day=moment(timestamp);
                    return  day.format("YYYY-MM-DD HH:mm");
                }},
                {"data":function(row){
                    return "<a href='javascript:;' class='resetPwd' rel='"+row.id+"'>重置密码</a>";
                }}
            ],
            "language": { //定义中文
                "search": "请输入英雄姓名或登录账号:",
                "zeroRecords": "没有匹配的数据",
                "lengthMenu": "显示 _MENU_ 条数据",
                "info": "显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoFiltered": "(从 _MAX_ 条数据中过滤得来)",
                "loadingRecords": "加载中...",
                "processing": "处理中...",
                "paginate": {
                    "first": "首页",
                    "last": "末页",
                    "next": "下一页",
                    "previous": "上一页"
                }
            }
        });

        //新增用户
        $("#newForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                username:{
                    required:true,
                    rangelength:[2,20],
                    remote:"/admin/user/checkusername"
                },
                realname:{
                    required:true,
                    rangelength:[2,20]
                },
                password:{
                    required:true,
                    rangelength:[6,20]
                },
                weixin:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入用户名",
                    rangelength:"用户名长度为2-20位",
                    remote:"该用户名已被占用"
                },
                realname:{
                    required:"请输入真实姓名",
                    rangelength:"真实姓名长度为2-20位"
                },
                password:{
                    required:"请输入密码",
                    rangelength:"密码长度为6-20位"
                },
                weixin:{
                    required:"请输入微信号"
                }
            },
            submitHandler:function(form){
                $.post("/admin/users/new",$(form).serialize()).done(function(data){
                    if(data=="success"){
                        $("#newModal").modal('hide');
                        dataTable.ajax.reload();
                    }
                }).fail(function(){
                    alert("服务器异常");
                });

            }

        });

        $("#newBtn").click(function(){
            $("#newForm")[0].reset();
            $("#newModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false

            });
        });

        $("#saveBtn").click(function(){
            $("#newForm").submit();
        });

        //重置密码
        $(document).delegate(".resetPwd","click",function(){
            var id=$(this).attr("rel");
            if(confirm("确认将密码重置为：000000")){
                $.post("/admin/users/resetpassword",{"id":id}).done(function(data){
                    if(data=="success"){
                        alert("重置密码成功");
                    }

                }).fail(function(){
                    alert("服务器异常");
                });
            }
        });

    });
</script>
</body>
</html>
