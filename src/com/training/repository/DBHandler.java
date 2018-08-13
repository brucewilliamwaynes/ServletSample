/**
 * 
 */
package com.training.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.User;
import com.training.utility.CommonAlgorithms;

/**
 * @author bridgelabz
 *
 */
public class DBHandler {

	public void readDetails( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String DBURL = "jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME") + "?user=" + System.getenv("DBUSER") + "&password=" + System.getenv("DBPASSWORD");

		//Establishing a connection to my given Database with the following User and password
		
		Connection connect = DriverManager.getConnection( DBURL );
		
		//Forming the query to find out if the user exists based on combination of umail and upass in LoginPage.jsp
		String checkQuery = "select umail from user where umail = ? and upass = ?;";
		
		//Reuse the email and passKey variable
		String umail = req.getParameter( "userEmail" );
		String upass = req.getParameter( "userPass" );
		
		//Forming a prepared Statement
		PreparedStatement preparedStatement = connect.prepareStatement( checkQuery  );
		
		//Filling up the ? values with the parameters from Form of Login page
		preparedStatement.setString(1,  umail );
		
		preparedStatement.setString(2, upass );
		
		//Executing query on database and then storing the value in ResultSet 
		ResultSet checkResult = preparedStatement.executeQuery();
		
		
		/*Checking if the result Set is not empty and has next then 
		*Creating a new session and redirecting to Welcome Servlet
		*Else redirect back to login Page or Registration Page based on whether email is registered or not
		*/
		if(checkResult.next()){

			//Filling details from earlier query
			umail = checkResult.getString( "umail" );
			
			//Forming details retrieval query from "details" table where the given umail matches.
			String detailsQuery = "select * from details where umail = ?";
			
			//Preparing the details query
			preparedStatement = connect.prepareStatement(  detailsQuery  );
			
			//Filling up ? with checkResult value from earlier query
			preparedStatement.setString(1, umail);
			
			//Retrieve result of detail query in Result Set 
			ResultSet detailResult = preparedStatement.executeQuery();
			
			//If query has matching rows in details where umail is same then
			if( detailResult.next() ){
				
				
				//Create a new User object and fill up (map ) the details to it
				User curUser = new User();
				
				//Map result set to user 
				CommonAlgorithms.mapToUser( detailResult , curUser );
				
				//Begin new Session for the current User
				HttpSession newSession = req.getSession( true );	
				
				
				//Setting new attribute of User object in session
				newSession.setAttribute( "User"  , curUser);
				
				//Close the ResultSet
				detailResult.close();
				
				//Redirecting to Home Servlet
				resp.sendRedirect("home");
				
			}
			
			//If umail is not registered in detail database 
			else{
				
				System.out.println( "Present in user database but not successfully registered absent in details database \n"   );
				
			}
			
			
		}
		
		//If checkQuery fails then redirect to Login page if email registered
		//Else redirect to Register Now page if email absent
		else{
			
			//Creating a query to check if email is registered 
			String checkEmailQuery = "select umail from user where umail = ? ;";
			
			//preparing a statement 
			preparedStatement = connect.prepareStatement( checkEmailQuery   );
			
			//Setting the value of ? to umail 
			preparedStatement.setString(1, umail );

			//Running query and holding it in ResultSet
			ResultSet emailSet = preparedStatement.executeQuery();
			
			//If email is present in user 
			if( emailSet.next()  ){
				
				//Closing the ResultSet
				emailSet.close();
				
				resp.sendRedirect("loginPage.jsp");
				return ;
				
			}
			
			//If not then redirect to Registration Page
			else{
				
				//Closing the resultSet
				emailSet.close();
				
				resp.sendRedirect("register.jsp");
				return;
			}
		
		}
		
		
		//Close all the connections 
		checkResult.close();
		
		preparedStatement.close();
		
		connect.close();
		
		return;
		
	}
	
	
}
