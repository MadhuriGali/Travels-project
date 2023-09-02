package com.ABCTravels;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String Gender;
	private String eMailId;
	private String password;
	public  void details() {
		System.out.println("You don't have account please sign up..!");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your first name");
		setFirstName(sc.next());
		System.out.println("enter your last name");
		setLastName(sc.next());
		System.out.println("enter your mobile number");
		setMobileNumber(sc.next());
		System.out.println("Enter your gender");
		setGender(sc.next());
		System.out.println("Enter your emailId");
		seteMailId(sc.next());
		System.out.println("enter your password");
		setPassword(sc.next());
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String i) {
		this.mobileNumber = i;
		mobileNumberVerification();
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String geteMailId() {
		return eMailId;
	}
	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		System.out.println("Thanks for your registration ");
	}
	private void mobileNumberVerification() {
		Pattern p=Pattern.compile("(0|91)?[6-9][0-9]{9}");
		Matcher m=p.matcher(mobileNumber);
		if((!m.find() && m.group().equals(mobileNumber))){
			System.out.println("Invalid mobile number ");
		}
				
		
	}
	
}

