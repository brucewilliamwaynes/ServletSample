/**
 * 
 */
package com.training.model;

/**
 * @author bridgelabz
 *
 */
public class User {
	
private String firstName;
private String lastName;
private String emailID;
private String password;
private String phoneNumber;

public User(){
	
	this.firstName = "";
	this.lastName = "";
	this.emailID = "";
	this.password = "";
	this.phoneNumber = "";
	
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the emailID
 */
public String getEmailID() {
	return emailID;
}
/**
 * @param emailID the emailID to set
 */
public void setEmailID(String emailID) {
	this.emailID = emailID;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the phoneNumber
 */
public String getPhoneNumber() {
	return phoneNumber;
}
/**
 * @param phoneNumber the phoneNumber to set
 */
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

@Override
public String toString() {
	return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + "]";
}
}
