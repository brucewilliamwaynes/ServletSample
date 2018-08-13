/**
 * 
 */
package com.training.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.training.model.User;
import com.training.repository.DBHandlingClass;
import com.training.utility.CommonAlgorithms;

/**
 * @author bridgelabz
 *
 */
public class LoginUser extends HttpServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User checkUser = new User();
		
		checkUser.setEmailID(request.getParameter("userEmail"));
		
		checkUser.setPassword(request.getParameter("userPass"));
		
		if(DBHandlingClass.checkUserExists(checkUser)){
		
			DBHandlingClass.readFromDB(checkUser);
		
			CommonAlgorithms.showUserDetails(checkUser);
		}
		
		else{
			
		}
	}

}
