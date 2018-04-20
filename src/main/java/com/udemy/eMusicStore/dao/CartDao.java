package com.udemy.eMusicStore.dao;

import com.udemy.eMusicStore.model.Cart;

/**
 * @author sandeep.chauhan
 *
 */
public interface CartDao {

	Cart getCartById(int id);
	void updateCart(Cart cart);
}

