package com.stantonscott.javabasics.cashregister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {

	//define constants to allow clean code
    private static final String HELP = "help";
    private static final String STOCK = "stock";
    private static final String CART = "cart";
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String CHECKOUT = "checkout";
    
    //define global class variables
    private static List<String> menuItems;
    private static Map<String, Integer> stock;
    private static Map<String, Float> price;
    private static Map<String, Integer> cart;
    
    //instantiate services
    //display service to handle output for the user
    //cart service to handle the users cart
    private static DisplayService displayService = new DisplayService();
    private static CartService cartService = new CartService();    
    
    //main method where the program starts and ends
	public static void main(String[] args) {
		
		// configure menu and stock etc.
		setupShop();
		
		// create a Scanner object to get keyboard input from command line
		// using "try with recourses" to handle errors https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try(Scanner userInputScanner = new Scanner(System.in)) { 
	        while(true) {
	        	displayService.displayDefault();
	
	        	// Store user input when user clicks enter
	            String userInput = userInputScanner.nextLine();
	
	            //execute different code depending on user input
	            if (userInput.toLowerCase().equals(HELP)) {
	            	displayService.displayMenu(menuItems);
	            } else if (userInput.toLowerCase().equals(STOCK)) {
	            	displayService.displayStock(stock, price);
	            } else if (userInput.toLowerCase().equals(CART)) {
	            	displayService.displayCart(cart, price, cartService.calculateCart(cart, price));
	            } else if (userInput.toLowerCase().startsWith(ADD)) {
	            	cartService.addItemToCart(userInput, stock, cart, price);
	            } else if (userInput.toLowerCase().startsWith(REMOVE)) {
	            	cartService.removeItemFromCart(userInput, stock, cart, price);
	            } else if (userInput.toLowerCase().equals(CHECKOUT)) {
	            	displayService.displayCheckout(cart, price, cartService.calculateCart(cart, price));
	            	cart = new HashMap<>();
	            } else {
	            	displayService.displayError();
	            }
	        }
        }
	}

	public static void setupShop() {
		
		//creates a list of strings to use when displaying the menu
		menuItems = new ArrayList<String>();
		menuItems.add("Help Menu");
		menuItems.add("help = Help Menu");
		menuItems.add("stock = Stock List");
		menuItems.add("cart = List of items in cart");
		menuItems.add("checkout = Make your purchase");
		menuItems.add("add <amount> <item> = Add items to cart");
		menuItems.add("remove <amount> <item> = Add items to cart");

		//creates a key value map to display and track stock amounts
		stock = new HashMap<>();
		stock.put("banana", 15);
		stock.put("milk", 2);
		stock.put("bread", 8);
		stock.put("cheese", 0);
		stock.put("soda", 5);

		//creates a key value map to display and track prices
		price = new HashMap<>();
		price.put("banana", 1.5F);
		price.put("milk", 2.0F);
		price.put("bread", 1.99F);
		price.put("cheese", 3.5F);
		price.put("soda", 4.0F);
		
		// create an empty cart
		cart = new HashMap<>();
	}
}
