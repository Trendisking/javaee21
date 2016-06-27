<%--
  Created by IntelliJ IDEA.
  User: 20330
  Date: 2016/6/26
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>HandlerBas</h3>
        </div>
        <button id="btn">Load Template</button>
        <div id="message" style="margin-top:20px;">

        </div>
    </div>
    <script src="/static/js/jquery-3.0.0.min.js"></script>
    <script src="/static/js/handlebars-v4.0.5.js"></script>
    <script type="kaishegnit/template" id="msgTemplate">
        <div class="panel panel-default">
            <div class="panel-heading ">
                {{author}}
                {{#if isVIP}}
                    <span class="text-danger">VIP</span>
                {{else}}
                <span class="text-danger">♥</span>
                {{/if}}
            </div>
            <div class="panel-body">
              <ul>
                  {{#each  msg}}
                    <li>{{this}}</li>
                  {{/each}}
              </ul>
            </div>
        </div>
    </script>
    <script>
        $(function(){
            $("#btn").click(function(){
                var json={"author":"李四","msg":["晚上敲代码","八月底毕业","九月找工作"],"isVIP":false};
                var source=$("#msgTemplate").html();
                var template=Handlebars.compile(source);
                var html=template(json);
                $("#message").prepend(html);
            });

        });
    </script>
</body>
</html>
