package com.DiceRolling;

//Benjamin McBrayer, 4.30.2018
//This Java console program simulates the rolling of dice.

import java.util.Scanner;
import java.util.Random;

public class DiceRolling {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numSides = 1;
		String playAgain = null;

		System.out.println("Welcome to the Grand Circus Casino!");

		// Ask for user information; greet user.
		System.out.println(getUserNameAndSayHello(scnr));

		do {// Take and verify user input; generate random integers; display special
			// messages for craps, snake eyes, and box cars; ask user if s/he wants to roll
			// again.
			checkForInteger(scnr);
			numSides = scnr.nextInt();
			if (numSides > 0 && numSides <= 20) {
				System.out.println("Roll:");
				rollDice(numSides);
			} else {
				System.out.println("Please enter a number between 1 and 20.");
			}
			System.out.println("Would you like to roll again (y/n)?");
			playAgain = scnr.next();

		} while (playAgain.equalsIgnoreCase("y"));

		// Bid the user adieu.
		System.out.println("Goodbye!");

		scnr.close();
	}

	public static String getUserNameAndSayHello(Scanner scnr) {
		System.out.print("Please enter your name: ");
		String userName = scnr.nextLine();
		return "Hello, " + userName + "!";
	}

	public static void checkForInteger(Scanner scnr) {
		System.out.println("How many sides should each die have?");
		while (!scnr.hasNextInt()) {
			System.out.println("A number, please!");
			scnr.next();
		}
	}

	public static void rollDice(int numSides) {
		final int NUM_VALS = 2;
		int[] rolls = new int[NUM_VALS];
		Random diceRoller = new Random();

		for (int i = 0; i < NUM_VALS; ++i) {
			rolls[i] = diceRoller.nextInt(numSides) + 1;
			System.out.println(rolls[i]);
		}
		if (rolls[0] + rolls[1] == 2) {
			System.out.println("Snake Eyes!");
		}
		if (rolls[0] + rolls[1] == 7 || rolls[0] + rolls[1] == 11) {
			System.out.println("Craps!");
		}
		if (rolls[0] == 6 && rolls[1] == 6) {
			System.out.println("Box Cars!");
		}
	}
}
