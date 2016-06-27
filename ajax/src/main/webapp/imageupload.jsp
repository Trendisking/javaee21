<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/26
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/webupload/webuploader.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Ajax图片上传</h3>
    </div>
    <div id="picker">选择文件</div>
    <h3>图片预览:</h3>
    <ul id="fileList" class="list-unstyled list-inline">



    </ul>


    <button id="btn" class="btn btn-success">开始上传</button>

</div>
<script src="/static/js/jquery-3.0.0.min.js"></script>
<script src="/static/js/webupload/webuploader.min.js"></script>
<script type="myTemplate" id="progressTemplate">
    <div class="progress">
        <div class="progress-bar progress-bar-success" role="progressbar"  style="width: 0%">
        </div>
    </div>
</script>
<script>
    $(function(){
        var uploader=WebUploader.create({
            swf:"/static/js/webupload/Uploader.swf",
            server:"/upload",
            pick:"#picker",
            fileVal:"file",
            accept:{
                title:'Images',
                extensions:'gif,jpg,jpeg,bmp,png',
                mimeTypes:'image/*'
            }
        });
        //将选择的文件放入文件队列中
        uploader.on("fileQueued",function(file){
            var html='<li id="'+file.id+'"><img  class="img-thumbnail"></li>';
            $("#fileList").append(html);
            uploader.makeThumb(file,function(error,src){
                if(error){

                    return;
                }
                $("#"+file.id).find("img").attr('src',src);
            },100,100);

        });
        //文件上传时调用的事件
        uploader.on("uploadProgress",function(file,percentage){
            percentage=parseInt(percentage*100);
            var $li=$("#"+file.id);
            if($li.find(".progress").length){
                $li.find(".progress .progress-bar").css("width",percentage+"%");
            }else{
                var template=$("#progressTemplate").html();
                $li.append(template);
            }




            /*
             var $li=$("#"+file.id);
             if($li.find("span").length){
             $li.find("span").text("上传中..."+percentage);
             }else{

             $li.append("<span>上传中...</span>");
             }
             if(percentage==100){
             $li.find("span").text("上传成功").fadeOut(3000);
             }*/



        });
        //文件上传成功
        uploader.on("uploadSuccess",function(file){
            $("#"+file.id).css("color","#ccc");
        });
        //文件上传失败
        uploader.on("uploadError",function(file){
            $("#"+file.id).css("color","darkred");
        });
        //无论文件上传成功或失败
        uploader.on("uploadComplete",function(file){

        });
        //手动上传
        $("#btn").click(function(){
            uploader.upload();
        });
    });
</script>
</body>
</html>

