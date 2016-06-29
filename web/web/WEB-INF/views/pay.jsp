<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/13
  Time: 17:46
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
    <form action="/pay" method="post">
        <input type="hidden" name="token" value="${requestScope.token}">
        <input type="text" name="money">
        <button>支付</button>
    </form>
</body>
</html>
