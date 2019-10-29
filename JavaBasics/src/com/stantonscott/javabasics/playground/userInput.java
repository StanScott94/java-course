package com.stantonscott.javabasics.playground;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class userInput {

    private static final String HELP = "help";
    private static final String TIME = "time";

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in); // Create a Scanner object to get keyboard input
        while(true) {
            System.out.println("Enter text and press Enter");

            String userInput = userInputScanner.nextLine(); // Read user input
            System.out.println("Text entered by user: " + userInput); // Output user input

            if (userInput.toLowerCase().equals(HELP)) {
                System.out.println("Help menu");
                System.out.println("- help = Help menue");
                System.out.println("- time = Print current time");
                System.out.println("create a help menu and maybe your own commands");
            } else if (userInput.toLowerCase().equals(TIME)) {
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date));
            }
        }
    }
}
