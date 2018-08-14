package com.training.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.User;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter( ServletRequest arg0, ServletResponse arg1, FilterChain chain )
			throws IOException, ServletException {
		
		HttpServletRequest req = ( HttpServletRequest )arg0;
		
		HttpServletResponse resp = ( HttpServletResponse  ) arg1;
		
		HttpSession curSession = req.getSession(false) ;
		
//		String name =  (String) curSession.getAttribute("Name");
		/*
		if( name == null ||  name.isEmpty()  ){
			
			resp.sendRedirect("loginPage.jsp");
			
		}
		
		else{
			
			chain.doFilter( req , resp  );
			
		}*/
		
		User curUser = ( User )curSession.getAttribute("User");  
		
		if( curUser == null ){
			
			resp.sendRedirect( "loginPage.jsp" );
		}
		
		else{
			
			chain.doFilter( req, resp );
			
		}
		
		
	}

}
