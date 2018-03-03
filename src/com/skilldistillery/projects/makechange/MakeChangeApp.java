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

		System.out.println();
		System.out.println("Have a nice day!");
		keyboard.close();
	}

	private static void giveChange(double payment, double price) {
		int startingChange = roundRepeatingDecimals(payment, price);

		numericalChange(startingChange);
		System.out.println();

		System.out.println("Or, if you prefer, your change is:");

		if (denominationDivision(startingChange, 2000) != 0) {
			if (denominationDivision(startingChange, 2000) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 2000) + " twenty dollar bills");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 2000) + " twenty dollar bill");
			}

			startingChange = startingChange - (2000 * denominationDivision(startingChange, 2000));
		}

		if (denominationDivision(startingChange, 1000) != 0) {
			if (denominationDivision(startingChange, 1000) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 1000) + " ten dollar bills");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 1000) + " ten dollar bill");
			}

			startingChange = startingChange - (1000 * denominationDivision(startingChange, 1000));
		}

		if (denominationDivision(startingChange, 500) != 0) {
			if (denominationDivision(startingChange, 500) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 500) + " five dollar bills");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 500) + " five dollar bill");
			}

			startingChange = startingChange - (500 * denominationDivision(startingChange, 500));
		}

		if (denominationDivision(startingChange, 100) != 0) {
			if (denominationDivision(startingChange, 100) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 100) + " one dollar bills");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 100) + " one dollar bill");
			}

			startingChange = startingChange - (100 * denominationDivision(startingChange, 100));
		}

		if (denominationDivision(startingChange, 25) != 0) {
			if (denominationDivision(startingChange, 25) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 25) + " quarters");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 25) + " quarter");
			}

			startingChange = startingChange - (25 * denominationDivision(startingChange, 25));
		}

		if (denominationDivision(startingChange, 10) != 0) {
			if (denominationDivision(startingChange, 10) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 10) + " dimes");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 10) + " dime");
			}

			startingChange = startingChange - (10 * denominationDivision(startingChange, 10));
		}

		if (denominationDivision(startingChange, 5) != 0) {
			if (denominationDivision(startingChange, 5) != 1) {
				System.out.println("\t" + denominationDivision(startingChange, 5) + " nickels");
			}
			else {
				System.out.println("\t" + denominationDivision(startingChange, 5) + " nickel");
			}

			startingChange = startingChange - (5 * denominationDivision(startingChange, 5));
		}

		if (startingChange != 0) {
			if (startingChange != 1) {
				System.out.println("\t" + startingChange + " pennies");
			}
			else {
				System.out.println("\t" + startingChange + " penny");
			}

		}

	}

	private static int roundRepeatingDecimals(double payment, double price) {
		double combinedTotal = ((payment - price) * 100);
		int roundedDecimals = 0;

		if ((combinedTotal - (int) combinedTotal) >= 0.5) {
			roundedDecimals = (int) combinedTotal + 1;
		}
		else {
			roundedDecimals = (int) combinedTotal;
		}

		return roundedDecimals;
	}

	private static void numericalChange(int startingChange) {
		System.out.println();
		System.out.print("Thank you! Your change today is $" + (startingChange / 100));

		if ((startingChange % 100) >= 10) {
			System.out.print("." + (startingChange % 100) + ".");
		}
		else {
			System.out.print(".0" + (startingChange % 100) + ".");
		}

	}

	private static int denominationDivision(int startingChange, int increment) {
		int denomination = startingChange / increment;
		if (denomination >= 1) {
			return denomination;
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