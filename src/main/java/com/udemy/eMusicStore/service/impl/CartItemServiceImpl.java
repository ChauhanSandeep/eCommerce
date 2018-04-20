package com.udemy.eMusicStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.eMusicStore.dao.CartItemDao;
import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;
import com.udemy.eMusicStore.service.CartItemService;

/**
 * @author sandeep.chauhan
 *
 */
@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;

	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	
	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);
	}


	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}


	@Override
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
		
	}

}
