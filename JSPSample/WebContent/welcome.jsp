<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Screen</title>
</head>
<body>
   <% String userName = request.getParameter("userName"); 
String address = (String)request.getAttribute("address");
String temp = (String)session.getAttribute("temp");
      %>
      Welcome <%=userName%>! <br>
      You are living at <%=address%> <br>
      Temp = <%=temp%>
</body>
</html>