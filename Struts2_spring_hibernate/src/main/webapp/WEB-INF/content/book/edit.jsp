<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>修改书籍</h3>
    </div>
    <div class="row">
        <div class="col-xs-4">


            <form action="/book/update.action" method="post">
                <input type="hidden" name="book.id" value="${book.id}">
                <div class="form-group">
                    <label>书籍名称</label>
                    <input type="text" name="book.bookname" value="${book.bookname}" class="form-control">
                </div>
                <div class="form-group">
                    <label>书籍作者</label>
                    <input type="text" name="book.bookauthor" value="${book.bookauthor}" class="form-control">
                </div>
                <div class="form-group">
                    <label>书籍价格</label>
                    <input type="text" name="book.bookprice" value="${book.bookprice}" class="form-control">
                </div>
                <div class="form-group">
                    <label>书籍数量</label>
                    <input type="text" name="book.booknum" value="${book.booknum}" class="form-control">
                </div>
                <div class="form-group">
                    <label>分类</label>
                    <select class="form-control" name="book.bookType.id">
                        <c:forEach items="${bookTypeList}" var="type">
                            <option ${book.bookType.id == type.id ? 'selected' : ''} value="${type.id}">${type.booktype}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>出版社</label>
                    <select class="form-control" name="book.publisher.id">
                        <c:forEach items="${publisherList}" var="pub">
                            <option ${book.publisher.id == pub.id ? 'selected' : ''} value="${pub.id}">${pub.pubname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary">保存</button>
                </div>
            </form>

        </div>
    </div>


</div>


</body>
</html>