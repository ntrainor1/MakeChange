package com.skilldistillery.projects.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Hello there, stranger.");
		System.out.print("What is the cost of your product? (in dollars, e.g. 1.20) ");
		double price = keyboard.nextDouble();

		System.out.print("I see. Give me some payment: (in dollars, e.g. 2.75) ");

		while (true) {
			double payment = keyboard.nextDouble();

			if (payment == price) {
				thankYou();
				break;
			}
			else if (payment < price) {
				insufficientPayment();
			}
			else {
				giveChange(payment, price);
				break;
			}

		}

		System.out.println("Have a nice day!");
		keyboard.close();
	}

	private static void giveChange(double payment, double price) {
		int startingChange = (int) ((payment - price) * 100);

		numericalChange(startingChange);

		System.out.print("or, if you prefer, your change is " + twentyDivision(startingChange) + " twenty dollar bills, ");
		startingChange = startingChange - (2000 * twentyDivision(startingChange));

		System.out.print(tenDivision(startingChange) + " ten dollar bills, ");
		startingChange = startingChange - (1000 * tenDivision(startingChange));

		System.out.print(fiveDivision(startingChange) + " five dollar bills, ");
		startingChange = startingChange - (500 * fiveDivision(startingChange));

		System.out.print(oneDivision(startingChange) + " one dollar bills, ");
		startingChange = startingChange - (100 * oneDivision(startingChange));

		System.out.print(quarterDivision(startingChange) + " quarters, ");
		startingChange = startingChange - (25 * quarterDivision(startingChange));

		System.out.print(dimeDivision(startingChange) + " dimes, ");
		startingChange = startingChange - (10 * dimeDivision(startingChange));

		System.out.print(nickelDivision(startingChange) + " nickels, and ");
		startingChange = startingChange - (5 * nickelDivision(startingChange));

		System.out.println(pennyDivision(startingChange) + " pennies.");
		startingChange = startingChange - (1 * pennyDivision(startingChange));

	}

	private static void numericalChange(int startingChange) {
		System.out.println();
		System.out.print("Your change today is " + (startingChange / 100) + " dollars and " + (startingChange % 100)
				+ " cents ");
	}

	private static int twentyDivision(int startingChange) {
		int twentyBills = startingChange / 2000;
		if (twentyBills >= 1) {
			return twentyBills;
		}
		else {
			return 0;
		}
	}

	private static int tenDivision(int startingChange) {
		int tenBills = startingChange / 1000;
		if (tenBills >= 1) {
			return tenBills;
		}
		else {
			return 0;
		}
	}

	private static int fiveDivision(int startingChange) {
		int fiveBills = startingChange / 500;
		if (fiveBills >= 1) {
			return fiveBills;
		}
		else {
			return 0;
		}
	}

	private static int oneDivision(int startingChange) {
		int oneBills = startingChange / 100;
		if (oneBills >= 1) {
			return oneBills;
		}
		else {
			return 0;
		}
	}

	private static int quarterDivision(int startingChange) {
		int quarters = startingChange / 25;
		if (quarters >= 1) {
			return quarters;
		}
		else {
			return 0;
		}
	}

	private static int dimeDivision(int startingChange) {
		int dimes = startingChange / 10;
		if (dimes >= 1) {
			return dimes;
		}
		else {
			return 0;
		}
	}

	private static int nickelDivision(int startingChange) {
		int nickels = startingChange / 5;
		if (nickels >= 1) {
			return nickels;
		}
		else {
			return 0;
		}
	}

	private static int pennyDivision(int startingChange) {
		int pennies = startingChange / 1;
		if (pennies >= 1) {
			return pennies;
		}
		else {
			return 0;
		}
	}

	private static void insufficientPayment() {
		System.out.print("Your payment falls short. Please insert the correct change. ");
	}

	private static void thankYou() {
		System.out.println("Thank you for using exact change.");
	}

}
