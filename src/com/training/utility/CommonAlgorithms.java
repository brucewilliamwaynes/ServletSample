/**
 * 
 */
package com.training.utility;

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
	
	
}
