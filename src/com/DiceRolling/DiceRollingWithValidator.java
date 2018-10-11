package com.DiceRolling;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author benjamin.mcbrayer
 *
 */
public class DiceRollingWithValidator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declare and initialize variables.
		Scanner scnr = new Scanner(System.in);
		String userName = null;
		int numSides = 1;
		int count = 1;
		String numStr1 = null;
		String numStr2 = null;
		String playAgain = null;

		// Introduce the program.
		System.out.println("Welcome to the Grand Circus Casino!");

		// Ask for user information; greet user.
		userName = Validator.getString(scnr, "Please enter your name: ");
		System.out.println("Hello, " + userName + "!");

		do {
			numSides = Validator.getInt(scnr, "How many sides should each die have?", 2, 20);

			System.out.println("Roll " + count + ":");
			numStr1 = rollDice(numSides);
			System.out.println(numStr1);
			numStr2 = rollDice(numSides);
			System.out.println(numStr2);
			System.out.println(getSpecial(numStr1, numStr2));
			++count;

			playAgain = Validator.getString(scnr, "Would you like to roll again (y/n)? ");

		} while (playAgain.equalsIgnoreCase("y"));

		// Bid the user adieu.
		System.out.println("Goodbye!");

		scnr.close();
	}

	public static String rollDice(int numSides) {
		Random diceRoller = new Random();
		String numStr = String.valueOf(diceRoller.nextInt(numSides) + 1);
		return numStr;
	}
	
	public static String getSpecial(String one, String two) {
		int num1 = Integer.parseInt(one);
		int num2 = Integer.parseInt(two);
		if (num1 + num2 == 2) {
			return "Snake Eyes!";
		}
		if (num1 + num2 == 7 || num1 + num2 == 11) {
			return "Craps!";
		}
		if (num1 == 6 && num2 == 6) {
			return "Box Cars!";
		} else {
			return "";
		}
	}
}
