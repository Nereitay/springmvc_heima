<!doctype html>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Annotation</title>
</head>
<body>
    <%--常用注解--%>
    <a href="anno/testRequestParam?name=Ryan">RequestParam注解</a>

    <br>

    <form action="anno/testRequestBody" method="post">

        用户姓名：<input type="text" name="username"/><br/>
        用户年龄：<input type="text" name="age"/><br/>

        <input type="submit" value="提交">
    </form>

    <br>

    <a href="anno/testPathVariable/10">PathVariable注解</a>

    <br>

    <a href="anno/testRequestHeader">RequestHeader注解</a>

    <br>

    <a href="anno/testCookieValue">CookieValue注解</a>

    <br>

    <form action="anno/testModelAttribute" method="post">

        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="age"/><br/>

        <input type="submit" value="提交">
    </form>

    <br>

    <a href="anno/testSessionAttributes">SessionAttributes注解: 存入request/session域中</a>

    <br>

    <a href="anno/getSessionAttributes">SessionAttributes注解：从request/session域中取值</a>

    <br>

    <a href="anno/delSessionAttributes">SessionAttributes注解：删空session域中的值</a>

</body>
</html>

    