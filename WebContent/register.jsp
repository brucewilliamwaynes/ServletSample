<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register User</title>
</head>
<body>
<h1>New User Registration</h1>
<form action="reg"  method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>EmailID</td>
					<td><input type="text" name="userEmail" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password"  /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="phoneNumber" /></td>
				</tr></table>
			<input type="submit" value="Submit" />
</form>

<a href="loginPage.jsp" style="text-decoration:none">Jump to Login Page</a>

</body>
</html>