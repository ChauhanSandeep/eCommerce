package com.udemy.eMusicStore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eMusicStore.dao.CartDao;
import com.udemy.eMusicStore.model.Cart;

/**
 * @author sandeep.chauhan
 *
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Cart getCartById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Cart)session.get(Cart.class, id);
	}

	
	@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		
	}

}
