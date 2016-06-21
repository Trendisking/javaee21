<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/20
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<button id="btn">发送Ajax请求</button>
    <script>
        (function(){
            function createXmlHttp(){
                var xmlHttp=null;
                if(window.ActiveXObject){
                     xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                }else{
                     xmlHttp=new XMLHttpRequest();
                }
                return xmlHttp;
            }
            document.querySelector("#btn").onclick=function(){
                var xmlHttp=createXmlHttp();
                xmlHttp.open("get","/ajax",true);
                xmlHttp.send();

            };



        })();
    </script>
</body>
</html>
