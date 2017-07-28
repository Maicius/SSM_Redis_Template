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
    <title>Login Success</title>
</head>
<body>
<h1> 登陆结果</h1>
<p id="success">${sessionScope.user.nickName}</p>
</body>
</html>
