<%@ page import="Controller.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: ledsinh
  Date: 12/6/18
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User successfully logged in</title>
</head>
<body>
    <center>
        <% UserBean currentUser = (new UserBean(session.getAttribute("currentSessionUser"))); %>

            /center>
</body>
</html>
