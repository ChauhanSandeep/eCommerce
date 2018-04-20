package com.udemy.eMusicStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.eMusicStore.dao.CartDao;
import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.service.CartService;

/**
 * @author sandeep.chauhan
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;

	@Override
	public Cart getCartById(int id) {
		return cartDao.getCartById(id);
	}


	@Override
	public void updateCart(Cart cart) {

		cartDao.updateCart(cart);
	}

}
