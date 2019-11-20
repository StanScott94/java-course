package com.stantonscott.javabasics.cashregister;

import com.sun.jdi.IntegerType;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.*;
import java.util.concurrent.*;

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
    public static final File menuFile = new File("C:\\Projects\\java-course\\JavaBasics\\src\\com\\stantonscott\\javabasics\\cashregister\\menu.txt");
    public static final File stockFile = new File("C:\\Projects\\java-course\\JavaBasics\\src\\com\\stantonscott\\javabasics\\cashregister\\StockItems");
    public static final File priceFile = new File("C:\\Projects\\java-course\\JavaBasics\\src\\com\\stantonscott\\javabasics\\cashregister\\Price");

    //Defining global variables

    public static List<String> menuItems = new ArrayList<String>();
    public static Map<String, Integer> stock = new HashMap<>();
    public static Map<String, Float> price = new HashMap<>();
    public static Map<String, Integer> cart = new HashMap<>();
    // ============================================================================================
    //
    // Main program logic
    //
    // ============================================================================================

    // main method where the program starts and ends
    public static void main(String[] args) {


        // configure menu and stock etc.
        try {
            setupShop();
        } catch (Exception exception) {
            System.out.println("Shop can't be started. Please come later.");
        }

        // create a Scanner object to get keyboard input from command line
        // using "try with recourses" to handle errors
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html


        try (Scanner userInputScanner = new Scanner(System.in)) {
            while (true) {
                displayDefault();

                // Store user input when user clicks enter
                String userInput = userInputScanner.nextLine();

                // execute different code depending on user input
                if (userInput.toLowerCase().equals(HELP)) {
                    displayMenu(menuItems);
                } else if (userInput.toLowerCase().equals(STOCK)) {
                    displayStock(stock, price);
                } else if (userInput.toLowerCase().equals(CART)) {
                    Float totalPrice = calculateCart(cart, price);
                    displayCart(cart, price, totalPrice);
                } else if (userInput.toLowerCase().startsWith(ADD)) {
                    addItemToCart(userInput, stock, cart, price);
                } else if (userInput.toLowerCase().startsWith(REMOVE)) {
                    removeItemFromCart(userInput, stock, cart, price);
                } else if (userInput.toLowerCase().equals(CHECKOUT)) {
                    Float totalPrice = calculateCart(cart, price);
                    displayCheckout(cart, price, totalPrice);
                    cart = new HashMap<>();
                } else {
                    displayError();
                }
            }
        }
    }

    public static void setupShop() throws ExecutionException, InterruptedException {
        //Creates a list to display the menu
        menuItems = (List<String>) Executors.newFixedThreadPool(1).submit(new ReadFromFile(menuFile, menuItems)).get();
        // creates a key value map to display and track stock amounts
        stock = (Map<String, Integer>) Executors.newFixedThreadPool(1).submit(new ReadFromFile(stockFile, stock)).get();
        // creates a key value map to display and track prices
        price = (Map<String, Float>) Executors.newFixedThreadPool(1).submit(new ReadFromFile(priceFile, price)).get();
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


}
