<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page HTML</title>
</head>
<body>
<form action="log" method="post">
	<table style="width:50%">
		<tr>
		<td>UserName</td>
		<td><input type="text" name="userEmail"  value="user@email.com"/> </td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="userPass"   value="Password" /> </td>
		</tr>
	</table>
	<input type="submit" value="Login"/>
	</form>
	<button type="button" id = "regBtn" onclick="location.href = 'register.jsp'">Register Here</button>
</body>
</html>