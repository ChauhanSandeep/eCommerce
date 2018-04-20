package com.udemy.eMusicStore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eMusicStore.dao.CartItemDao;
import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;

/**
 * @author sandeep.chauhan
 *
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}


	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}


	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem cartItem : cartItems){
			removeCartItem(cartItem);
		}
	}


	
	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0, productId);
		CartItem cartItem = (CartItem) query.uniqueResult();
		session.flush();
		return cartItem;
	}

}
