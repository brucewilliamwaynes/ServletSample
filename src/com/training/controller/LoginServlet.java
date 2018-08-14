/**
 * 
 */
package com.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.repository.DBHandler;
import com.training.utility.CommonAlgorithms;

/**
 * @author brucewilliamwaynes
 *Class which acts as a servlet for loginPage.jsp 
 *Functionalities : checkIf UserExists()
 *									redirectToWelcomePage()
 *
 */
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Getting form element in post format from loginPage.jsp
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Authenticating for empty or spaces in login
		if(CommonAlgorithms.authenticate(req,resp)){
			
			//DBObj created for DBHandler to map user and readDetails
			DBHandler dbObj = new DBHandler();
			
			try {
				
				System.out.println( "Inside Servlet!"  );
				
				dbObj.readDetails(req, resp);
			
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
				
			}
			
		}
	
		//If empty spaces present then redirect to loginPage.jsp
		else{
			
			//Display details in console
			System.out.println( "Empty or Spaces in Text"  );
			
			resp.sendRedirect("loginPage.jsp");
			
		}
		
	}
	
}
