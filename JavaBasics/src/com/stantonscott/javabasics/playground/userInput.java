package com.stantonscott.javabasics.playground;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author stantonscott
 * @version 1.0
 *
 *          <p>
 *          Creation Date: 29.10.19
 *          </p>
 *          <p>
 *          Project Name: JavaBasics
 *          </p>
 */
public class userInput {

	private static final String HELP = "help";
	private static final String TIME = "time";
	private static final String QUIT = "quit";

	public static void main(String[] args) {
		// Create a Scanner object to get keyboard input
		Scanner userInputScanner = new Scanner(System.in);
		try {
			boolean isRunning = true;
			while (isRunning) {
				System.out.println("Enter text and press Enter");

				String userInput = userInputScanner.nextLine(); // Read user input
				System.out.println("Text entered by user: " + userInput); // Output user input

				if (userInput.toLowerCase().equals(HELP)) {
					System.out.println("Help menu");
					System.out.println("- help = Help menue");
					System.out.println("- time = Print current time");
					System.out.println("- quit = Quit the program");
					System.out.println("create a help menu and maybe your own commands");
				} else if (userInput.toLowerCase().equals(TIME)) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date date = new Date(System.currentTimeMillis());
					System.out.println(formatter.format(date));
				} else if (userInput.toLowerCase().equals(QUIT)) {
					System.out.println("Good Bye Traveler");
					isRunning = false;
				}
			}
		} finally {
			userInputScanner.close();
		}
	}
}
