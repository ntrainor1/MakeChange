package com.skilldistillery.projects.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Hello there, stranger.");
		System.out.print("What is the cost of your product? (in dollars, e.g. 1.20) ");
		double price = keyboard.nextDouble();
		
		System.out.print("I see. Give me some payment: (in dollars, e.g. 2.75) ");
		double payment = keyboard.nextDouble();
		
		keyboard.close();
	}

}
