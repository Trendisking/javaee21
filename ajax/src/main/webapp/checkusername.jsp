<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/20
  Time: 15:50
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
    <input type="text" id="username"><span id="help_text"></span>
    <script>

        document.querySelector("#username").onchange=function(){
            var username=this.value;
            var xmlHttp=createXmlHttp();
            xmlHttp.open("get","/checkusername?username="+encodeURIComponent(username)+"&_="+new Date().getTime());
            //xmlHttp.open("get","/checkusername?username="+encodeURIComponent(username));
            xmlHttp.onreadystatechange=function(){
                var readyState=xmlHttp.readyState;
                //alert("readyState: "+readyState);
                if(readyState==4){
                    var httpState=xmlHttp.status;
                    if(httpState==200){
                        var result=xmlHttp.responseText;
                       if(result=="yes"){
                           document.querySelector("#help_text").innerText="√";
                       }else{
                           document.querySelector("#help_text").innerText="账号已被占用";
                       }


                    }else{
                        alert("服务器请求异常: "+httpState);
                    }
                }
            };
            xmlHttp.send();
        };
    </script>
</body>
</html>
