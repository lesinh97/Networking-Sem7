<%--
  Created by IntelliJ IDEA.
  User: ledsinh
  Date: 11/29/18
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action = "CheckLoginServlet" method="post">
        Username: <input type="text" name="userName"/>
        Password: <input type="password" name = "password"/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>

