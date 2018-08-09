/**
 * 
 */
package com.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.training.model.User;

/**
 * @author bridgelabz
 *
 */
public class DBHandlingClass {
	private Statement statement = null;
	private Connection connectUser = null;
	private Connection connectDetails = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet =  null;
	
	
	public void writeToDB(User newUser){
	
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");

            connectUser = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
            
            connectDetails = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
            
            preparedStatement = connectUser.prepareStatement(
            		"insert into user values(default, ? , ? );"
            		);
            
            preparedStatement.setString(1, newUser.getEmailID());
            
            preparedStatement.setString(2, newUser.getPassword());
            
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            
            preparedStatement = connectDetails.prepareStatement(
            		"insert into details values(default, ? , ? , ? , ? , ?);"
            		);
			
            preparedStatement.setString(1, newUser.getFirstName());
            
            preparedStatement.setString(2, newUser.getLastName());
            
            preparedStatement.setString(3, newUser.getEmailID());
            
            preparedStatement.setString(4, newUser.getPassword());
            
            preparedStatement.setString(5, newUser.getPhoneNumber());
            
		}catch(Exception e){
			
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		finally{}

	}
		
}
