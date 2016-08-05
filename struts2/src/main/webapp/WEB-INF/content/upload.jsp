<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/8/3
  Time: 20:43
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
    <form action="/file/upload.do" method="post" enctype="multipart/form-data">
        <input type="text" name="name">
        <input type="file" name="photo">
        <input type="file" name="photo">
        <input type="file" name="photo">
        <button>Upload</button>


    </form>

    <p>
        <a href="/file.download.do">点此下载文件</a>
    </p>
</body>
</html>
