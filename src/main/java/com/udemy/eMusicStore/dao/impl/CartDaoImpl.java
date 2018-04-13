package com.udemy.eMusicStore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.udemy.eMusicStore.dao.CartDao;
import com.udemy.eMusicStore.model.Cart;

/**
 * @author sandeep.chauhan
 *
 */
@Repository
public class CartDaoImpl implements CartDao {
	
	private Map<String, Cart> listOfCarts;
	
	
	public CartDaoImpl() {
		super();
		listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.containsKey(cart.getCartId())){
			throw new IllegalArgumentException(String.format("Cannot create a cart. A cart Id with the given id (%) already" +
												"exists", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void updateCart(String cartId, Cart cart) {
		if(!listOfCarts.containsKey(cartId)){
			throw new IllegalArgumentException(String.format("Cannot update the cart. A cart Id with the given id (%) does not " +
					"exists", cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}
	
	@Override
	public void delete(String cartId) {
		if(!listOfCarts.containsKey(cartId)){
			throw new IllegalArgumentException(String.format("Cannot delete the cart. A cart Id with the given id (%) does not " +
					"exists", cartId));
		}
		else{
			listOfCarts.remove(cartId);
		}
	}

}
