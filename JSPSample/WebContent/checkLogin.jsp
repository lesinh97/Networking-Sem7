<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String address = "193 Nguyen Luong Bang"; // Dung ra la lay DB va truy cap vao DB de kiem thu username va password co dung hay ko?
    // Java co ban
    if ("Chi pheo".equals(userName) && (!"".equals(password))) {
    	// Thanh cong: Di ve trang welcome.jsp
    request.setAttribute("address", address); 	
    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
    	rd.forward(request, response);
    } else {// That bai: Di ve trang login.jsp
    	response.sendRedirect("login.jsp");    	
    	
    }
%>