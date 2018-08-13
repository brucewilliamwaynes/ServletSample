/**
 * 
 */
package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.User;

/**
 * @author bridgelabz
 *
 */
public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		
		//Retrieving old session
		HttpSession newSession = request.getSession();
		
		//Retrieving user  details from user  
		User curUser = (User) newSession.getAttribute("User");
		
		//Adding new Attribute to request and forwarding to home.jsp 
		request.setAttribute( "Name",  curUser.getFirstName() );
		
		//Creating new dispatcher to forward request to home.jsp
		RequestDispatcher newDispatcher;
		
		//Initializing newDispatcher
		newDispatcher = request.getRequestDispatcher( "/home.jsp" );
		
		newDispatcher.forward(  request   , response );
		
		return;
		
	}
	
}
