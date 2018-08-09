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
public class RegistrationUser extends GenericServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		
		String[] parametres = new String[12];
		
		parametres[0] = request.getParameter("firstName");
		
		parametres[1] = request.getParameter("lastName");
		
		parametres[2] = request.getParameter("userEmail");
		
		parametres[3] = request.getParameter("password");
		
		parametres[4] = request.getParameter("flatNumber");
		
		parametres[5] = request.getParameter("buildingName");
		
		parametres[6] = request.getParameter("streetNumber");
		
		parametres[7] = request.getParameter("landmark");
		
		parametres[8] = request.getParameter("city");
		
		parametres[9] = request.getParameter("state");
		
		parametres[10] = request.getParameter("zipcode");
		
		parametres[11] = request.getParameter("phoneNumber");
		
		
		
	}

}
