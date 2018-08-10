/**
 * 
 */
package com.training.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.training.model.User;
import com.training.repository.DBHandlingClass;

/**
 * @author bridgelabz
 *
 */
public class RegistrationUser extends GenericServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		
		User newUser = new User();
		
		newUser.setFirstName(request.getParameter("firstName"));
		
		newUser.setLastName(request.getParameter("lastName"));
		
		newUser.setEmailID(request.getParameter("userEmail"));
		
		newUser.setPassword(request.getParameter("password"));
		
		newUser.setPhoneNumber(request.getParameter("phoneNumber"));
	
		DBHandlingClass.writeToDB(newUser);
		
		System.out.println("Written Succesfully on DB");
		
	}

}
