<!doctype html>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HiddentHttpMethodFilter</title>
</head>
<body>
    <%--保存--%>
    <form action="springmvc/testRestPOST" method="post">
        用户名称：<input type="text" name="uname"><br/>
        <%--<input type="hidden" name="_method" value="POST">--%>
        <input type="submit" value="保存">
    </form>
    <hr/>
    <%--更新--%>
    <form action="springmvc/testRestPUT/1" method="post">
        用户名称：<input type="text" name="uname"><br/>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="更新">
    </form>
    <hr/>
    <%--删除--%>
    <form action="springmvc/testRestDELETE/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="删除">
    </form>
    <hr/>
    <%--查询一个--%>
    <form action="springmvc/testRestGET/1" method="post">
        <input type="hidden" name="_method" value="GET">
        <input type="submit" value="查询">
    </form>

</body>
</html>

    