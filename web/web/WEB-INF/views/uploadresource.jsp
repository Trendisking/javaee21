<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/19
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="col-xs-4">
        <form action="/uploadresource" enctype="multipart/form-data"  method="post" >
            <div class="form-group">
                <label>description</label>
                <input type="text" name="description" class="form-control">
                <label>select file</label>
                <input type="file" name="doc" class="form-control">
                <button class="btn btn-primary">save</button>

            </div>


        </form>
    </div>
</div>

</body>
</html>
