/**
 * 
 */
package com.training.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.model.User;

/**
 * @author bridgelabz
 *
 */
public class CommonAlgorithms {

	public static void showUserDetails(User curUser){
		
		System.out.println("Hey :" + curUser.getFirstName() + "   " + curUser.getLastName());
		
		System.out.println("Registered Number :" + curUser.getPhoneNumber());
		
	}

	//To authenticate  in form submission
	public static boolean authenticate(HttpServletRequest req, HttpServletResponse resp) {
	
		
		//Checking for empty or just spaces as input in UserEmail and UserPassword Parameter
		if(( String.valueOf( req.getParameter( "userEmail" ) ).trim() != null ) && ( String.valueOf( req.getParameter( "userPass" ) ).trim() != null) )
			return true;
		
		return false;
	}

	
	//To map result set details to User object for Data Abstraction
	public static void mapToUser(ResultSet detailResult, User curUser) throws SQLException {
		//Non-empty ResultSet containing details of a row of user
		
		//Mapping Fname, Lname, Phone, Umail to User object
		
		curUser.setFirstName( detailResult.getString( "fname" ) );
		
		curUser.setLastName( detailResult.getString( "lname" )  );
		
		curUser.setEmailID(  detailResult.getString( "umail"   )   );
		
		curUser.setPhoneNumber( detailResult.getString( "unumb"  )   );
		
		
		//Password would be sent from query from initial resultSet from checkQuery
		
	}
	
	
}
