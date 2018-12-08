/<!DOCTYPE html>
<html>
<head>
  <%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Page Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
  <script src="main.js"></script>
</head>
<body>
  <% 
  String userName = request.getParameter("userName");
  String password = request.getParameter("password");
  String address = "gg" // Dung DB
  if("hello".equals(userName) && (!".equals(password"))) {
    request.setAttribute("address", address);
    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
    rd.forward(request,respone);
  }
  else {
    respone.sendRedirect("login.jsp");
  }
  %>
</body>
</html>