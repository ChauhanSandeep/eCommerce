package com.udemy.eMusicStore.service;

import com.udemy.eMusicStore.model.Cart;

/**
 * @author sandeep.chauhan
 *
 */
public interface CartService {
	
	Cart getCartById(int id);
	void updateCart(Cart cart);

}
