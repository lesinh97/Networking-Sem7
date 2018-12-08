<%@ page language="java" contentType="text/html; charset=UTF-8"
			pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Screen</title>
</head>
<body>
       <%
            String temp = "temp";
            session.setAttribute("temp", temp);
       %>
    <form action="checkLogin.jsp" method="post">
      Username: <input type="text" name="userName" />
      Password: <input type="password" name="password" />
           <input type="submit" value="OK" /> 
           <input type="reset" value="Reset" />                
        </form>
</body>
</html>