/**
 * 
 */
package com.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.model.User;

/**
 * @author bridgelabz
 *
 */
public class DBHandlingClass {
	private static Statement statement = null;
	private static Connection connectUser = null;
	private static Connection connectDetails = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet =  null;
	
	
	public static void writeToDB(User newUser){
	
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DBURL = "jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME") + "?user=" + System.getenv("DBUSER") + "&password=" + System.getenv("DBPASSWORD");
			
			connectUser = DriverManager.getConnection(DBURL);
			
			connectDetails = DriverManager.getConnection(DBURL);
			
            preparedStatement = connectUser.prepareStatement(
            		"insert into user values(default, ? , ? );"
            		);
            
            preparedStatement.setString(1, newUser.getEmailID());
            
            preparedStatement.setString(2, newUser.getPassword());
            
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
           
            
            preparedStatement = connectDetails.prepareStatement(
            		"insert into details values(default, ? , ? , ? , ? );"
            		);
			
            preparedStatement.setString(1, newUser.getFirstName());
            
            preparedStatement.setString(2, newUser.getLastName());
            
            preparedStatement.setString(3, newUser.getEmailID());
            
            preparedStatement.setString(4,  newUser.getPhoneNumber());
            
            preparedStatement.addBatch();
            
            preparedStatement.executeBatch();
            
            
		}catch(Exception e){
			
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		finally{
			close();
		}

	}
	
	
	public static void readFromDB(User newUser){
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DBURL = "jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME") + "?user=" + System.getenv("DBUSER") + "&password=" + System.getenv("DBPASSWORD");
			
			connectUser = DriverManager.getConnection(DBURL);
			
			connectDetails = DriverManager.getConnection(DBURL);
			
			preparedStatement = connectUser.prepareStatement(
					"select umail from user where umail = ? and upass = ?;"
					);
			
			preparedStatement.setString(1, newUser.getEmailID());
			
			preparedStatement.setString(2, newUser.getPassword());
			
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			
			preparedStatement = connectDetails.prepareStatement(
							"select fname,lname,unumb from details where umail = ? ;"
			);
					
					preparedStatement.setString(1, resultSet.getString("umail"));
					
					ResultSet newMapSet = null;
					
					newMapSet = preparedStatement.executeQuery();
					
					newMapSet.next();
					
					newUser.setFirstName(newMapSet.getString("fname"));
					
					newUser.setLastName(newMapSet.getString("lname"));
					
					newUser.setPhoneNumber(newMapSet.getString("unumb"));
			
			
		}catch(Exception e){
			
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		finally{
			close();
		}
		
	}
	
	public static void close(){

        try{

            if (resultSet != null) resultSet.close();

            if (statement != null) statement.close();

            if (connectUser != null) connectUser.close();

            if (connectDetails != null) connectDetails.close();

            
        }

        catch (Exception e) {


        }

    }
		
}
