/**
 * 
 */
package com.training.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author brucewilliamwaynes
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener{

	private int sessionCount  = 0 ; 
	
	public void sessionCreated( HttpSessionEvent sessionEvent) {
		
		synchronized( this ){
			
			sessionCount++;
			
		}
		
		System.out.println( "Session created ID : " + sessionEvent.getSession().getId()  );
		
		System.out.println( "Active User Count :" + sessionCount  );
	
	}
	
	public void sessionDestroyed(  HttpSessionEvent  sessionEvent  ){
		
		synchronized( this ){
			
			sessionCount--;
			
		}
		
		
		System.out.println(  "Session destroyed ID :" + sessionEvent.getSession().getId()  );
		
		System.out.println(  "Active User Count " + sessionCount   );
		
	}
	
	
}
