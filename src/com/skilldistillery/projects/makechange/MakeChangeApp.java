package com.skilldistillery.projects.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// The program begins by prompting the customer for the cost of their product.
		System.out.println("Hello there, stranger.");
		System.out.print("What is the cost of your product? (in dollars, e.g. 1.20) ");
		double price = keyboard.nextDouble();

		// The program then prompts the customer for payment.
		System.out.print("I see. Give me some payment: (in dollars, e.g. 2.75) ");

		/*
		 * The program then runs in an infinite loop in asking for payment. If the cost
		 * of payment is met, the loop is broken. Otherwise, it will keep prompting the
		 * user until the price is met.
		 */
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

		// Once the customer has paid, the program says goodbye, closes its Scanner, and
		// terminates the program.
		System.out.println();
		System.out.println("Have a nice day!");
		keyboard.close();
	}

	// This giveChange() method first evaluates the raw change when judged against
	// the payment and the price.
	private static void giveChange(double payment, double price) {
		/*
		 * First, the program needs to deduct the price from the payment in the
		 * roundRepeatingDecimals() method.
		 * 
		 * Then, it needs to convert the change into an int for the sake of simplicity.
		 */

		int startingChange = roundRepeatingDecimals(payment, price);

		/*
		 * The numericalChange() method then outputs the change in dollar format (e.g.
		 * $14.50), in case the customer might prefer to see their change in numerical
		 * format.
		 */
		numericalChange(startingChange);
		System.out.println();

		/*
		 * The denominationDivision() method then outputs the change in denomination
		 * format (e.g. one ten dollar bill four one dollar bills two quarters).
		 * 
		 * The program then prints out the results in the above format, however, the
		 * denominationDivision() method also judges the results in the event that there
		 * are 0 of a given denomination.
		 * 
		 * In the above example, there were no twenty dollar bills, so the program would
		 * not output "0 twenty dollar bills."
		 * 
		 * Likewise, it also judges if there is only 1 of a given denomination and
		 * outputs the appropriate response (e.g. 1 ten dollar bill as opposed to 1
		 * twenty dollar bills).
		 */
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

	/*
	 * In addition to , this method must also judge against repeating decimals (e.g.
	 * 0.3333333334 or 0.6666666667) that generate incorrect results when the
	 * decimals are dropped in the data casting.
	 */
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

	/*
	 * This method determines the numerical format of the change and judges
	 * accordingly for cents, i.e. printing ".0" before single digit cents.
	 */
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

	/*
	 * This method determines precisely how many of a given denomination of currency
	 * to return to giveChange().
	 */
	private static int denominationDivision(int startingChange, int increment) {
		int denomination = startingChange / increment;
		if (denomination >= 1) {
			return denomination;
		}
		else {
			return 0;
		}
	}

	// This method generates the response for insufficient payment.
	private static void insufficientPayment() {
		System.out.print("Your payment falls short. Please insert the correct change. ");
	}

	// This method generates the response for exact payment.
	private static void thankYou() {
		System.out.println("Thank you for using exact change.");
	}

}