package com.udemy.eMusicStore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eMusicStore.dao.CustomerDao;
import com.udemy.eMusicStore.model.Authorities;
import com.udemy.eMusicStore.model.BillingAddress;
import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.Customer;
import com.udemy.eMusicStore.model.Users;

/**
 * @author sandeep.chauhan
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		Users user = new Users();
		user.setUsername(customer.getCustomerName());
		user.setPassword(customer.getPassword());
		user.setEnabled(true);
		user.setCustomerId(customer.getCustomerId());
		session.saveOrUpdate(user);
		
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_USER");
		authorities.setUsername(customer.getCustomerName());
		session.saveOrUpdate(authorities);
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(cart);
		
		session.flush();

	}

	
	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.flush();
		return customer;
	}


	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		session.flush();
		return customers;
	}

}
