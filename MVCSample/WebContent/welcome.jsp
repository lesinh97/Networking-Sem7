<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.Wife" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
   <table>
    <%
       ArrayList<Wife> wifeArray = (ArrayList<Wife>)request.getAttribute("wifeArray");
       for (int i = 0; i < wifeArray.size(); i++) {  
    %>
          <tr>
             <td><%= wifeArray.get(i).getName()%></td>
             <td><%= wifeArray.get(i).getAddress()%></td>
             <td><%= wifeArray.get(i).isAlive()%></td>
          </tr>   
    
    <% } %>
    </table>
</body>
</html>