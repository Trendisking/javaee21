<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/24
  Time: 0:22
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
<input type="text" id="keyword">
<button id="btn">翻译</button>
<p id="result"></p>
<script src="/static/js/jquery-3.0.0.min.js"></script>
<script>
    $(function(){
        $("#btn").click(function(){

            var url="http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&callback=?&version=1.1";
            var keyword=$("#keyword").val();//encodeURIComponent($("#keyword").val());
            $.getJSON(url,{"q":keyword},function(json){
                var str="";
                var array=json.basic.explains;

                for(var i=0;i<array.length;i++){
                    str+=array[i]+"<br>";
                }
                $("#result").html(str);


            });




            /*$.getJSON("/jsonp?callback=?",function(result) {
                alert(result.name);
            });*/
        });

        /*function handler(result){
            console.log("callback-------"+result.id);
        }

        $("#btn").click(function(){
            $.get("/jsonp",{"callback":"handler"},function(data){
                eval(data);

            })
        });*/
    });
</script>
</body>
</html>
