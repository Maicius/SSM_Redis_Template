<%--
  Created by IntelliJ IDEA.
  User: maicius
  Date: 2017/3/31
  Time: 下午9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="\userRegist.action" method="get">
    <input type="text" name="userName" placeholder="用户名"/>
    <input type="text" name="nickName" placeholder="昵称"/>
    <input type="password" name="password" placeholder="密码" />
    <input type="submit" value="注册"/>
</form>
</body>
</html>
