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
		int startingChange = (int) ((payment - price) * 100);

		numericalChange(startingChange);
		System.out.println();

		System.out.print("Or, if you prefer, your change is:");

		if (twentyDivision(startingChange) != 0) {
			if (twentyDivision(startingChange) != 1) {
				System.out.println("\t" + twentyDivision(startingChange) + " twenty dollar bills");
			}
			else {
				System.out.println("\t" + twentyDivision(startingChange) + " twenty dollar bill");
			}
			
			startingChange = startingChange - (2000 * twentyDivision(startingChange));
		}

		if (tenDivision(startingChange) != 0) {
			if (tenDivision(startingChange) != 1) {
				System.out.print("\t" + tenDivision(startingChange) + " ten dollar bills");
			}
			else {
				System.out.print("\t" + tenDivision(startingChange) + " ten dollar bill");
			}
			
			startingChange = startingChange - (1000 * tenDivision(startingChange));
		}

		if (fiveDivision(startingChange) != 0) {
			if (fiveDivision(startingChange) != 1) {
				System.out.print("\t" + fiveDivision(startingChange) + " five dollar bills");
			}
			else {
				System.out.print("\t" + fiveDivision(startingChange) + " five dollar bill");
			}
			
			startingChange = startingChange - (500 * fiveDivision(startingChange));
		}

		if (oneDivision(startingChange) != 0) {
			if (oneDivision(startingChange) != 1) {
				System.out.print("\t" + oneDivision(startingChange) + " one dollar bills");
			}
			else {
				System.out.print("\t" + oneDivision(startingChange) + " one dollar bill");
			}
			
			startingChange = startingChange - (100 * oneDivision(startingChange));
		}

		if (quarterDivision(startingChange) != 0) {
			if (quarterDivision(startingChange) != 1) {
				System.out.print("\t" + quarterDivision(startingChange) + " quarters");
			}
			else {
				System.out.print("\t" + quarterDivision(startingChange) + " quarter");
			}
			
			startingChange = startingChange - (25 * quarterDivision(startingChange));
		}

		if (dimeDivision(startingChange) != 0) {
			if (dimeDivision(startingChange) != 1) {
				System.out.print("\t" + dimeDivision(startingChange) + " dimes");
			}
			else {
				System.out.print("\t" + dimeDivision(startingChange) + " dime");
			}
			
			startingChange = startingChange - (10 * dimeDivision(startingChange));
		}

		if (nickelDivision(startingChange) != 0) {
			if (nickelDivision(startingChange) != 1) {
				System.out.print("\t" + nickelDivision(startingChange) + " nickels");
			}
			else {
				System.out.print("\t" + nickelDivision(startingChange) + " nickel");
			}
			
			startingChange = startingChange - (5 * nickelDivision(startingChange));
		}

		if (pennyDivision(startingChange) != 0) {
			if (pennyDivision(startingChange) != 1) {
				System.out.print("\t" + pennyDivision(startingChange) + " pennies");
			}
			else {
				System.out.print("\t" + tenDivision(startingChange) + " penny");
			}
			
			startingChange = startingChange - (1 * pennyDivision(startingChange));
			
			System.out.println(startingChange);
		}

	}

	private static void numericalChange(int startingChange) {
		System.out.println();
		System.out.print("Your change today is $" + (startingChange / 100));

		if ((startingChange % 100) >= 10) {
			System.out.print("." + (startingChange % 100) + ".");
		}
		else {
			System.out.print(".0" + (startingChange % 100) + ".");
		}

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
