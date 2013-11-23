<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
</head>
<body>
<% String name = (String) session.getAttribute("user"); %>
<% java.util.Date cr = new java.util.Date(session.getCreationTime()); %>
<% java.util.Date lr = new java.util.Date(session.getLastAccessedTime()); %>
<div style="font-size:25px;">Click here to <a href="Logout">logout</a></div>
<center>
	<div style="font-size: 30px;">
		<div>Hello <%=name %></div>
		<div>Login time:<%=cr %></div>
		<div>Last accessed time:<%=lr %></div>
	</div>
</center>
</body>
</html>