<%@ page  language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"   import="com.training.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title> Welcome </title>
</head>
<body>
	<%
	//Getting current Session
	HttpSession curSession = request.getSession( false );
	
	System.out.println ( "Before ");
	
	if( ! curSession.equals(null) ){
		
		System.out.println( "Inside CurSession ");
		
		//Retrieve Object User
		User newUser = ( User )curSession.getAttribute("User");
			
		//Retrieving values
			out.println(" Welcome " + newUser);
			
			//Redirecting to Logout.jsp on button press
	}	
	
	else{
		
		response.sendRedirect( "loginPage.jsp"  );
	
	}
	%>
	<br></br>
<button name="lgOBtn" onclick="location.href = 'logOut.jsp'"> Log Out </button>
</body>
</html>