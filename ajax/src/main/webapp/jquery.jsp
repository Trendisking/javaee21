<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/23
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <button id="btn1">get json</button>
        <button id="btn2">Ajax method</button>
        <img src="/static/image/logging.gif" id="loadImage" style="display:none">
    </div>
    <script src="/static/js/jquery-3.0.0.min.js"></script>
    <script>
        $(function(){
            $("#btn2").click(function(){
                var $this=$(this);
                $.ajax({
                    url:"/user.json",//请求路径
                    type:"get",//请求方式get/post
                    data:{"name":"merry"},//发送到服务器的数据
                    timeout:10000,//设置请求超时时间
                    success:function(data){//成功时执行的回调函数
                        console.log("success function");
                        alert(":)");

                    },
                    error:function(data){//错误时执行的回调方法
                        alert("请求服务器异常");
                    },
                    complete:function(){//无论成功还是失败都会执行的回调方法
                        console.log("complete function");
                        $this.text("Ajax method").removeAttr("disabled");//当现实为 Ajax method，去除disabled属性,可以重复点击
                        $("#loadImage").hide();
                    },
                    beforeSend:function(){//在ajax发送之前执行的回调方法
                        console.log("before function");
                        $this.text("sending....").attr("disabled","disabled");//当显示sending时禁用按钮，防止重复点击
                        $("#loadImage").show();
                    }


                });

            });






            $("#btn1").click(function(){
                $.getJSON("/user.json")
                        .done(function(data){
                            console.log(data);
                        })
                        .fail(function(){
                            alert("请求服务器异常");
                        })
                        .always(function(){
                            console.log("always-----------------------");
                        });
            });

        });
    </script>
</body>
</html>
