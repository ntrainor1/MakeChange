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
		double startingChange = payment - price;
		int twentyBill = 0, tenBill = 0, fiveBill = 0, oneBill = 0, quarter = 0, dime = 0, nickel = 0, penny = 0;

		System.out.println((int)(startingChange*100));

		System.out.println("Your change is " + twentyBill + " twenty dollar bills, " + tenBill + " ten dollar bills, " + fiveBill + " five dollar bills, " + oneBill + " one dollar bills, " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels, " + penny + " and pennies.");
	}

	private static void insufficientPayment() {
		System.out.print("Your payment falls short. Please insert the correct change. ");
	}

	private static void thankYou() {
		System.out.println("Thank you for using exact change.");
	}

}
