<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/23
  Time: 18:10
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
<input  type="text" id="username">
<span id="help_text"></span>
<hr>
<button id="btn">Send Post Ajax</button>
<hr>
<button id="jsonBtn">get Json Data</button>
<ul id="jsonList"></ul>
<hr>
<button id="xmlBtn">get XML Data</button>
<div id="userBox"></div>

<script src="/static/js/jquery-3.0.0.min.js"></script>
<script>
    $(function(){
        $("#xmlBtn").click(function(){
            var $userBox=$("#userBox");
            $userBox.html("");
            $.get("/user.xml",function(xml){
                $(xml).find("user").each(function(){
                    var id=$(this).attr("id");
                    var name=$(this).find("username").text();
                    var address=$(this).find("address").text();
                    console.log("id: "+ id + " name: "+ name +  " address: " + address);
                    $userBox.append("<div><h4>"+name+"<small>"+id+"</small></h4><p>"+address+"</p></div>");
                });
            });
        });






        $("#jsonBtn").click(function(){
            var $ul=$("#jsonList");
            $.get("/user.json",function(data){
                for(var i=0;i<data.length;i++){
                    var user=data[i];
                    $ul.append("<li>"+user.name+"</li>");

                   /* var li=document.createElement("li");
                    var text=document.createTextNode(id+"--->"+name);
                    li.appendChild(text);
                    document.getElementById("list").appendChild(li);*/
                }

            })
        });


        $("#btn").click(function(){
            $.post("/ajax",{"name":"jquery","address":"ajax"},function(result){
                console.log(result);
            });
        });

        $("#username").change(function(){
            var name=$(this).val();
            $.get("/checkusername",{"username":name},function(result){
                if(result=="yes"){
                    $("#help_text").text("√");
                }else{
                    $("#help_text").text("该账号 已被占用");
                }
            });
        });
    });
</script>
</body>
</html>
