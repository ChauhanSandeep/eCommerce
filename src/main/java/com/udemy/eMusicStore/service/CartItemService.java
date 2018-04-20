package com.udemy.eMusicStore.service;

import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;

/**
 * @author sandeep.chauhan
 *
 */
public interface CartItemService {

	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int id);
}
