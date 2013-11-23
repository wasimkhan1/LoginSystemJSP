<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome Page</title>
</head>
<body>
	<% String name = (String)session.getAttribute("user"); %>
	<div style="font-size:25px;">click here to <a href="Logout">logout</a></div>
	<h1>Hello <%=name %></h1>
	
</body>
	