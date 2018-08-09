/**
 * 
 */
package com.training;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author bridgelabz
 *
 */
public class LoginUser extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userEmail = request.getParameter("userEmail");
		
		String userPass = request.getParameter("userPass");
		
		
		
	}

}
