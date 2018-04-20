package com.udemy.eMusicStore.dao;

import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;

/**
 * @author sandeep.chauhan
 *
 */
public interface CartItemDao {
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
