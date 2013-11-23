<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body bgcolor="#D0D0D0">
<div align='center'>
	<form id="loginform" action="Validate" method="post">
		<div style="font-size: 40px; font-weight: bolder; ">Login Page</div>
		<table>
			<tr>
				<td><label for="loginid">UserId</label></td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td><label for="pass">Password</label></td>
				<td><input type="password" name="pid"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>