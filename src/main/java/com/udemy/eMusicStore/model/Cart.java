package com.udemy.eMusicStore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandeep.chauhan
 *
 */
public class Cart {

	private String cartId;
	private Map<Integer, CartItem> cartItems;
	private double grandTotal;

	public Cart() {
		cartItems = new HashMap<Integer, CartItem>();
		grandTotal = 0;
	}

	public Cart(String sessionId) {
		this();
		this.cartId = sessionId;
	}

	public String getCartId() {
		return cartId;
	}

	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void addCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();

		if (cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productId, existingCartItem);
		} else {
			cartItems.put(productId, item);
		}
		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}

	private void updateGrandTotal() {
		grandTotal = 0;
		for(CartItem item: cartItems.values()){
			grandTotal += item.getTotalPrice();
		}
	}
}
