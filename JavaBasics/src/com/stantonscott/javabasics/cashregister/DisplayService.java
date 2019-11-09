package com.stantonscott.javabasics.cashregister;

import java.util.List;
import java.util.Map;

public class DisplayService {
	
	//define constants to allow clean code
	private static final String DEFAULT = "Enter \"help\" to see Help Menu ";
    private static final String OUT_OF_STOCK = "Item Out Of Stock";
    private static final String BORDER = "============================================";
    private static final String INVALID_INPUT = "Invalid Input";

	public void displayDefault() {
		System.out.println(DEFAULT);
	}
    
	public void displayMenu(List<String> menuItems) {
		displayBorder();
		menuItems.forEach(menuItem -> System.out.println(menuItem));
		displayBorder();
	}
	
	public void displayStock(Map<String, Integer> stock,  Map<String, Float> price) {
		displayBorder();
		for(Map.Entry<String,Integer> stockItem : stock.entrySet()) {
			System.out.println(stockItem.getValue() + " x " + stockItem.getKey() + " " + price.get(stockItem.getKey()) + "$ each");
		}
		displayBorder();
	}
	
	public void displayCart(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		displayBorder();
		System.out.println("Items in cart: ");
		displayItemsInCart(cart, price, totalPrice);
		displayBorder();
	}
	
	public void displayCheckout(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		displayBorder();
		System.out.println("Items in order: ");
		displayItemsInCart(cart, price, totalPrice);
		System.out.println("Thank you for your purchase");
		displayBorder();
	}
	
	public void displayItemsInCart(Map<String, Integer> cart, Map<String, Float> price, Float totalPrice) {
		for(Map.Entry<String,Integer> cartItem : cart.entrySet()) {
			Float priceForItem = price.get(cartItem.getKey()) * cartItem.getValue();
			System.out.println(cartItem.getValue() + " x " + cartItem.getKey() + " " + priceForItem + "$");
		}
		System.out.println("Total price: " + totalPrice);
	}
	
	public void displayOutOfStock() {
		displayBorder();
		System.out.println(OUT_OF_STOCK);
		displayBorder();
	}
	
	public void displayBorder() {
		System.out.println(BORDER);
	}
	
	public void displayError() {
		displayBorder();
		System.out.println(INVALID_INPUT);
		displayBorder();
	}
}
