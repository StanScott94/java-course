package com.stantonscott.javabasics.cashregister.custom1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	// define constants to allow clean code
	private static final String HELP = "help";
	private static final String STOCK = "stock";
	private static final String CART = "cart";
	private static final String ADD = "add";
	private static final String REMOVE = "remove";
	private static final String CHECKOUT = "checkout";
	private static final String DEFAULT = "Enter \"help\" to see Help Menu ";
	private static final String OUT_OF_STOCK = "Item Out Of Stock";
	private static final String BORDER = "============================================";
	private static final String INVALID_INPUT = "Invalid Input";
	private static final String ERROR_DURING_SETUP = "There was an error during setup ";

	// ============================================================================================
	//
	// Main program logic
	//
	// ============================================================================================

	// main method where all java programs starts
	public static void main(String[] args) {

		// define method variables
		List<String> menuItems = new ArrayList<>();
		Map<String, Integer> stock = new HashMap<>();
		Map<String, Float> price = new HashMap<>();
		Map<String, Integer> cart = new HashMap<>();

		// configure menu and stock etc.
		try {
			setupShop(menuItems, stock, price);
		} catch (IOException e) {
			displaySetupError(e);
		}

		// create a Scanner object to get keyboard input from command line
		// using "try with resources" to handle errors
		// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		try (Scanner userInputScanner = new Scanner(System.in)) {
			while (true) {
				displayDefault();

				// Store user input when user clicks enter
				String userInput = userInputScanner.nextLine();

				// execute different code depending on user input
				if (userInput.equalsIgnoreCase(HELP)) {
					displayMenu(menuItems);
				} else if (userInput.equalsIgnoreCase(STOCK)) {
					displayStock(stock, price);
				} else if (userInput.equalsIgnoreCase(CART)) {
					Float totalPrice = calculateCart(cart, price);
					displayCart(cart, price, totalPrice);
				} else if (userInput.toLowerCase().startsWith(ADD)) {
					addItemToCart(userInput, stock, cart, price);
				} else if (userInput.toLowerCase().startsWith(REMOVE)) {
					removeItemFromCart(userInput, stock, cart, price);
				} else if (userInput.equalsIgnoreCase(CHECKOUT)) {
					Float totalPrice = calculateCart(cart, price);
					displayCheckout(cart, price, totalPrice);
					cart = new HashMap<>();
				} else {
					displayError();
				}
			}
		}
	}

	// ============================================================================================
	//
	// Configuration logic
	//
	// ============================================================================================

	// fill collections with values from and external configuration file
	public static void setupShop(List<String> menuItems, Map<String, Integer> stock, Map<String, Float> price) throws IOException {

		String[] menuItemsFromConfig = getValuesFromConfigFile("JavaBasics/configfiles/cashregister/menuItemsConfig.txt");
		String[] stockFromConfig = getValuesFromConfigFile("JavaBasics/configfiles/cashregister/stockConfig.txt");
		String[] priceFromConfig = getValuesFromConfigFile("JavaBasics/configfiles/cashregister/priceConfig.txt");

		fillListWithConfiguredValues(menuItems, menuItemsFromConfig);
		fillStockWithConfiguredValues(stock, stockFromConfig);
		fillPriceWithConfiguredValues(price, priceFromConfig);

	}

	// open file, read file into a string and separate the values by ","
	// using "try with resources" to handle errors
	// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
	public static String[] getValuesFromConfigFile(String configPath) throws IOException {
		String logTime = new SimpleDateFormat("mm:ss.SSS").format(new Date());
		System.out.println("retrieving values from " + configPath + " " + logTime);
		try (BufferedReader buffer =  Files.newBufferedReader(Paths.get(configPath))) {
			return (buffer.lines().collect(Collectors.joining("\n"))).split(",");
		}
	}

	private static void fillListWithConfiguredValues(List<String> List, String[] configuredValues) {
		Arrays.asList(configuredValues);
	}

	// fill a map separating the key and values by ":"
	private static void fillStockWithConfiguredValues(Map<String, Integer> map, String[] configuredValues) {
		for (String item: configuredValues) {
			String[] keyValues = item.split(":");
			String key = keyValues[0];
			Integer value = Integer.valueOf(keyValues[1]);
			map.put(key, value);
		}
	}

	// fill a map separating the key and values by ":"
	private static void fillPriceWithConfiguredValues(Map<String, Float> map, String[] configuredValues) {
		for (String item: configuredValues) {
			String[] keyValues = item.split(":");
			String key = keyValues[0];
			Float value = Float.valueOf(keyValues[1]);
			map.put(key, value);
		}
	}

	// ============================================================================================
	//
	// Cart specific logic
	//
	// ============================================================================================

	public static void addItemToCart(String userInput, Map<String, Integer> stock, Map<String, Integer> cart,
			Map<String, Float> price) {
		// use try catch to prevent errors when working with arrays etc.
		try {
			// split up user input into individual words
			String[] string = userInput.split(" ");
			String itemToAdd = string[2];
			int amountToAdd = Integer.parseInt(string[1]);

			// check if item is in stock before adding to cart
			// add to items cart
			// update stock
			if (stock.containsKey(itemToAdd) && stock.get(itemToAdd) >= amountToAdd) {

				if (cart.containsKey(itemToAdd)) {
					cart.put(itemToAdd, cart.get(itemToAdd) + amountToAdd);
				} else {
					cart.put(itemToAdd, amountToAdd);
				}

				stock.put(itemToAdd, stock.get(itemToAdd) - amountToAdd);
				Float totalPrice = calculateCart(cart, price);
				displayCart(cart, price, totalPrice);
			} else {
				displayOutOfStock();
			}
		} catch (Exception e) {
			displayError();
		}
	}

	public static void removeItemFromCart(String userInput, Map<String, Integer> stock, Map<String, Integer> cart,
			Map<String, Float> price) {
		// use try catch to prevent errors when working with arrays etc.
		try {
			// split up user input into individual words
			String[] string = userInput.split(" ");
			String itemToRemove = string[2];
			int amountToRemove = Integer.parseInt(string[1]);

			// check if item exists stock before removing from cart
			// remove items from cart
			// update stock
			if (cart.containsKey(itemToRemove) && cart.get(itemToRemove) >= amountToRemove) {
				cart.put(itemToRemove, cart.get(itemToRemove) - amountToRemove);
				stock.put(itemToRemove, stock.get(itemToRemove) + amountToRemove);

				if (cart.get(itemToRemove) == 0) {
					cart.remove(itemToRemove);
				}

				Float totalPrice = calculateCart(cart, price);
				displayCart(cart, price, totalPrice);
			} else {
				displayError();
			}
		} catch (Exception e) {
			displayError();
		}
	}

	public static Float calculateCart(Map<String, Integer> cart, Map<String, Float> price) {
		Float totalPrice = 0F;
		for (Map.Entry<String, Integer> cartItem : cart.entrySet()) {
			Float priceForItem = price.get(cartItem.getKey()) * cartItem.getValue();
			totalPrice += priceForItem;
		}
		return totalPrice;
	}

	// ============================================================================================
	//
	// Display specific logic
	//
	// ============================================================================================

	public static void displayDefault() {
		System.out.println(DEFAULT);
	}

	public static void displayMenu(List<String> menuItems) {
		displayBorder();
		menuItems.forEach(System.out::println);
		displayBorder();
	}

	public static void displayStock(Map<String, Integer> stock, Map<String, Float> price) {
		displayBorder();
		for (Map.Entry<String, Integer> stockItem : stock.entrySet()) {
			System.out.println(
					stockItem.getValue() + " x " + stockItem.getKey() + " " + price.get(stockItem.getKey()) + "$ each");
		}
		displayBorder();
	}

	public static void displayCart(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		displayBorder();
		System.out.println("Items in cart: ");
		displayItemsInCart(cart, price, totalPrice);
		displayBorder();
	}

	public static void displayCheckout(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		displayBorder();
		System.out.println("Items in order: ");
		displayItemsInCart(cart, price, totalPrice);
		System.out.println("Thank you for your purchase");
		displayBorder();
	}

	public static void displayItemsInCart(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		for (Map.Entry<String, Integer> cartItem : cart.entrySet()) {
			Float priceForItem = price.get(cartItem.getKey()) * cartItem.getValue();
			System.out.println(cartItem.getValue() + " x " + cartItem.getKey() + " " + priceForItem + "$");
		}
		System.out.println("Total price: " + totalPrice);
	}

	public static void displayOutOfStock() {
		displayBorder();
		System.out.println(OUT_OF_STOCK);
		displayBorder();
	}

	public static void displayBorder() {
		System.out.println(BORDER);
	}

	public static void displayError() {
		displayBorder();
		System.out.println(INVALID_INPUT);
		displayBorder();
	}

	public static void displaySetupError(IOException e) {
		displayBorder();
		System.out.println(ERROR_DURING_SETUP + e.getMessage());
		displayBorder();
	}
}
