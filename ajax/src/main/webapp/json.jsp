<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <button id="btn">Get Json</button>
    <ul id="list">
    </ul>
    <script>
        (function(){
            function createXmlHttp(){
                var xmlHttp=null;
                if(window.ActiveXObject){
                    xmlHttp=new ActiveXObject("Microsoft XMLHTTP");
                }else{
                    xmlHttp=new XMLHttpRequest;
                }
                return xmlHttp;
            }
            document.querySelector("#btn").onclick=function(){
                var xmlHttp=createXmlHttp();
                xmlHttp.open("get","/user.json",true);
                xmlHttp.onreadystatechange=function(){
                    if(xmlHttp.readyState==4){
                        if(xmlHttp.status==200){
                            var result=xmlHttp.responseText;//获取服务器端返回的字符串
                            var json=JSON.parse(result);//将字符串转换为JSON ES5
                            for(var i=0;i<json.length;i++){
                                var user=json[i];
                                var id=user.id;
                                var name=user.name;
                                var score=user.score;
                                var li=document.createElement("li");
                                var text=document.createTextNode(id+"--->"+name);
                                li.appendChild(text);
                                document.getElementById("list").appendChild(li);
                            }
                        }
                    }
                };
                xmlHttp.send();

            };













           /* var array=[
                {
                "name":"java",
                "type":"language"
                },
                {
                    "name":"php",
                    "type":"language"
                }
            ];
            for(var i=0;i<array.length;i++){
                var n=array[i];
                console.log(n.name+"-->"+ n.type);
            }

            var obj={
                "name":"java",
                "type":"language"
            };
            alert(obj.name);
            alert(obj.type);
            alert(obj["name"]);*/



        })();
    </script>
</body>
</html>
