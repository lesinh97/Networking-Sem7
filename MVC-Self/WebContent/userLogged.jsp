<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "login.UserBean" 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Logged Successfully</title>
</head>
<body>

         <center>
           <% UserBean currentUser = (UserBean)(session.getAttribute("currentSessionUser",user)); %>
			
            Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
         </center>

</body>
</html>
