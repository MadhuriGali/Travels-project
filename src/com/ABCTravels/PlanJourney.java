package com.ABCTravels;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PlanJourney {
	static int numberOfSeats;
	static HashMap<String, Integer> vacancy = new HashMap<String, Integer>();

	public static void Journey() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> source = new ArrayList<String>(Arrays.asList("AndhraPradesh", "Telangana", "Tamilnadu", "Goa",
				"Bihar", "Odisha", "Harayana", "MadhyaPradesh"));
		ArrayList<String> destinaton = new ArrayList<String>(Arrays.asList("AndhraPradesh", "Telangana", "Tamilnadu",
				"Goa", "Bihar", "Odisha", "Harayana", "MadhyaPradesh"));
		HashMap<String, Integer> finalData = new HashMap<String, Integer>();
		finalData.put("AndhraPradesh-Telangana", 50);
		finalData.put("AndhraPradesh-Tamilnadu", 60);
		System.out.println("Please enter your source from given list");
		System.out.println(source);
		String passangerSource = sc.next();
		System.out.println("Please enter your destination from given list");
		System.out.println(destinaton);
		String passangerDestination = sc.next();
		String finalDestination = passangerSource + "-" + passangerDestination;

		System.out.println("Enter on which day of month  you need to book the bus ");
		LocalDate todayDate = LocalDate.now();
		int userDate = sc.nextInt();
		LocalDate date = todayDate.withDayOfMonth(userDate);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int wrongDate = todayDate.compareTo(date);
		if (wrongDate > 0) {
			System.out.println("Please enter correct date you are entering the past dates");
			System.exit(1);
		}
		vaccancies(finalData, finalDestination);
		if (finalData.containsKey(finalDestination)) {
			int bill = finalData.get(finalDestination) * 10 * numberOfSeats;
			if (dayOfWeek.toString() != "SATURDAY" && dayOfWeek.toString() != "SUNDAY") {
				System.out.println(dayOfWeek.toString());
				System.out.println("your bill is " + bill);

			} else {
				int extraBill = bill + 200;
				System.out.println("your bill is " + extraBill);
			}

		}
		System.out.println("Thanks for chooosing us");
		MenuClass.storingDetails();

	}

	public static void vaccancies(HashMap<String, Integer> finalData, String finalDestination) {
		Scanner sc = new Scanner(System.in);
		if(numberOfSeats==0) {
		Set<String> keys = finalData.keySet();
		Iterator iterator = keys.iterator();
		while (iterator.hasNext()) {
			vacancy.put((String) iterator.next(), 30);
		}}
		System.out.println("Number of vacancies available for your destination is" + vacancy.get(finalDestination));
		if (vacancy.get(finalDestination) <= 30) {
			System.out.println("Enter the number of seats you need to book");
			setNumberOfSeats(sc.nextInt());
			vacancy.put(finalDestination, 30 - numberOfSeats);
		} else {
			System.out.println("Sorry no vacancies for today you can try next day ");
			System.out.println("Thank you");
			System.exit(1);
		}
	}

	public static int getNumberOfSeats() {
		return numberOfSeats;
	}

	public static void setNumberOfSeats(int numberOfSeats) {
		PlanJourney.numberOfSeats = numberOfSeats;
	}

}
