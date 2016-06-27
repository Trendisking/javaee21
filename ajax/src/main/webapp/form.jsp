<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/23
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"  href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-4">
            <form id="regForm">
                <legend>注册表单</legend>
                <div class="form-group">
                    <label>账号</label>
                    <input type="text" class="form-control" name="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="text" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label>个人简介</label>
                    <input type="text" class="form-control" name="other">
                </div>
                <div class="form-group">
                    <button type="button" id="subBtn" class="btn btn-primary">注册</button>
                </div>

            </form>
        </div>
    </div>
</div>
    <script src="/static/js/jquery-3.0.0.min.js"></script>
    <script src="/static/js/jquery.validate.min.js"></script>
    <script>
       $(function(){
           $("#regForm").validate({
               errorElement:"span",
               errorClass:"text-danger",
               rules:{
                    username:{
                        required:true,
                        minlength:3,
                        remote:"/checkusername"
                    },
                   password:{
                       required:true,
                       rangelength:[6,18]

                   },
                   other:{
                       required:true
                   }
               },
               messages:{
                   username:{
                       required:"请输入账号",
                       minlength:"账号至少三位字符",
                       remote:"该账号已被占用"
                   },
                   password:{
                       required:"请输入密码",
                       rangelength:"密码长度为6-18位"
                   },
                   other:{
                       required:"请输入简介"
                   }
               },
               submitHandler:function(form){
                   var $btn=$("#subBtn");
                   $.ajax({
                       url:"/reg",
                       type:"post",
                       data:$(form).serialize(),//username=x&password=x&other=x
                       beforeSend:function(){
                           $btn.text("注册中....").attr("disabled","disabled");
                       },
                       success:function(){
                          alert("注册成功");
                       },
                       error:function(){
                           alert("服务器 较忙，请您稍后再试");
                       },
                       complete:function(){
                           $btn.text("注册").removeAttr("disabled");
                       }
                   });
               }

           });

           $("#subBtn").click(function(){
               $("#regForm").submit();
           });
       });
    </script>
</body>
</html>
