package com.ABCTravels;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuClass {
	static UserRegistration u = new UserRegistration();
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> al = new ArrayList<String>();
	public static void main(String[] args) {
		storingDetails();		
	}

	public static void storingDetails() {
		System.out.println("Welcome to BLUE BUS Travels");
		System.out.println("If you don't have an account please enter the text signup ");
		System.out.println("If you already have an account please enter the txt sign in");
		String checkingDetails=sc.next();
		if(checkingDetails.equalsIgnoreCase("signup")) { 
			u.details();
			al.add(u.getFirstName());
			al.add(u.getLastName());
			if(al.contains(u.getMobileNumber())) {
				System.out.println("You have already registered with these mobile number please try with another mobile number");
				System.exit(1);
			}else al.add(u.getMobileNumber());
			al.add(u.getGender());
			if(al.contains(u.geteMailId())) {
				System.out.println("You have already registered with these emailId please try with another emailId");
				System.exit(1);
			}else al.add(u.geteMailId());
			al.add(u.getPassword());
			login(al);
		}else {	
			//System.out.println(al);
			login(al);
		}
		

	}

	public static void login(ArrayList<String> al) {
		//System.out.println(al);
		int failedCount = 0;
		System.out.println("please enter your username and password to login");
		while (failedCount <= 5) {
			String username = sc.next();
			String password = sc.next();
			if (al.contains(username) && al.contains(password)) {
				System.out.println("successfully login");
				PlanJourney.Journey();
				break;
			} else {
				failedCount += 1;
			}
			System.out.println("Login failed try after 5 minutes");
			System.exit(1);
		}

	}

}
