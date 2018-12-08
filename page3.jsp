<head>
<meta http-equiv ="Content-Type" content = "text/html; charset = UTF-8">
<title>Welcome</title>
</head>
<body>
<% String userName = request.getParameter("userName");
String address = (String)request.getAttribute("address");
String temp = (String)session.getAttribute("temp");
%>
Welcome <% =userName %>!<br>
