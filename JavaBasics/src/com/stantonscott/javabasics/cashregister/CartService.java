package com.stantonscott.javabasics.cashregister;

import java.util.Map;

public class CartService {
	
	private DisplayService displayService = new DisplayService();

	public void addItemToCart(String userInput, Map<String, Integer> stock, Map<String, Integer> cart,  Map<String, Float> price) {
		//use try catch to prevent errors when working with arrays etc.
		try {
			//split up user input into individual words
			String[] string = userInput.split(" ");
			String itemToAdd = string[2];
			int amountToAdd = Integer.parseInt(string[1]);
			
			//check if item is in stock before adding to cart
			//add to items cart
			//update stock
			if (stock.containsKey(itemToAdd) && stock.get(itemToAdd) >= amountToAdd) {
				
				if (cart.containsKey(itemToAdd)) {
					cart.put(itemToAdd, cart.get(itemToAdd) + amountToAdd);
				} else {
					cart.put(itemToAdd, amountToAdd);
				}
				
				stock.put(itemToAdd, stock.get(itemToAdd) - amountToAdd);
				displayService.displayCart(cart, price, calculateCart(cart, price));
			} else {
				displayService.displayOutOfStock();
			}
		} catch (Exception e) {
			displayService.displayError();
		}
	}
	
	public void removeItemFromCart(String userInput, Map<String, Integer> stock, Map<String, Integer> cart,  Map<String, Float> price) {
		//use try catch to prevent errors when working with arrays etc.
		try {
			//split up user input into individual words
			String[] string = userInput.split(" ");
			String itemToRemove = string[2];
			int amountToRemove = Integer.parseInt(string[1]);
			
			//check if item exists stock before removing from cart
			//remove items from cart
			//update stock
			if (cart.containsKey(itemToRemove) && cart.get(itemToRemove) >= amountToRemove) {
				cart.put(itemToRemove, cart.get(itemToRemove) - amountToRemove);
				stock.put(itemToRemove, stock.get(itemToRemove) + amountToRemove);
				
				if (cart.get(itemToRemove) == 0) {
					cart.remove(itemToRemove);
				}
			
				displayService.displayCart(cart, price, calculateCart(cart, price));
			} else {
				displayService.displayError();
			}
		} catch (Exception e) {
			displayService.displayError();
		}
	}
	
	public Float calculateCart(Map<String, Integer> cart,  Map<String, Float> price) {
		Float totalPrice = 0F;
		for(Map.Entry<String,Integer> cartItem : cart.entrySet()) {
			Float priceForItem = price.get(cartItem.getKey()) * cartItem.getValue();
			totalPrice += priceForItem;
		}
		return totalPrice;
	}
}
