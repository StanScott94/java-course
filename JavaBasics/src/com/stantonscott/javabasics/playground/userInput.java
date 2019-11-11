package com.stantonscott.javabasics.playground;

import java.util.*;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class userInput {

    public static List<String> stockList;
    public static Map<String, Integer> stock;

    private static final String HELP = "help";
    private static final String STOCK = "stock";

    public static void main(String[] args) {
        setup();
        Scanner userInputScanner = new Scanner(System.in); // Create a Scanner object to get keyboard input
        while(true) {
            System.out.println("Enter help to see menu");

            String userInput = userInputScanner.nextLine(); // Read user input

            if (userInput.toLowerCase().equals(HELP)) {
                System.out.println("Help menu");
                System.out.println(HELP + " = Help menue");
                System.out.println(STOCK + " = View what's in stock");
            } else if (userInput.toLowerCase().equals(STOCK)) {
                stock.forEach(
                        (string, integer) -> System.out.println(integer + " x " + string + " currently in stock")
                );
            }
        }
    }

    private static void setup() {
        stockList = new ArrayList<String>() {
            {
                add("banana");
                add("soap");
                add("toothpaste");
                add("bread");
                add("orange juice");
                add("milk");
            }
        };

        stock = new HashMap<String, Integer>() {
            {
                put("banana", 32);
                put("soap", 4);
                put("toothpaste", 11);
                put("bread", 9);
                put("orange juice", 0);
                put("milk", 8);
            };
        };
    }
}
