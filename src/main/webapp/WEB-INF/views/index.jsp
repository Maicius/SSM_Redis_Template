<%--
  Created by IntelliJ IDEA.
  User: maicius
  Date: 2017/3/31
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<form action="\clickRegist.action", method="get">
    <input type="submit" value="注册"/>
</form>

<form action="\userLogin.action" method="get">
    <input type="text" name="userName" placeholder="用户名"/>
    <input type="password" name="password" placeholder="密码" />
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
