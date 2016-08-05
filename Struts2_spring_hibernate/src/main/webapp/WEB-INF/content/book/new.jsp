<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/7/5
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css"/>
</head>
<body>
    <div  class="container">
        <div class="page-header">
            <h3>编辑书籍</h3>
        </div>
        <div class="row">
            <div class="col-xs-4">

                <form action="/book/save.action" method="post">
                    <div class="form-group">
                        <label>书籍名称</label>
                        <input type="text" name="book.bookname" class="form-control " value="${book.bookname}"/>
                    </div>
                    <div class="form-group">
                        <label>书籍作者</label>
                        <input type="text" name="book.bookauthor" class="form-control " value="${book.bookauthor}"/>
                    </div>
                    <div class="form-group">
                        <label>书籍价格</label>
                        <input type="text" name="book.bookprice" class="form-control " value="${book.bookprice}"/>
                    </div>
                    <div class="form-group">
                        <label>书籍数量</label>
                        <input type="text" name="book.booknum" class="form-control " value="${book.booknum}"/>
                    </div>
                    <div class="form-group">
                        <label>分类</label>
                        <select class="form-control" name="book.bookType.id">
                            <c:forEach items="${bookTypeList}" var="type">
                                <option value="${type.id}">${type.booktype}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>出版社</label>
                        <select class="form-control" name="book.publisher.id">
                            <c:forEach items="${publisherList}" var="pub">
                                <option value="${pub.id}">${pub.pubname}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn bg-primary">保存</button>
                    </div>

                </form>

            </div>
        </div>
    </div>
</body>
</html>
