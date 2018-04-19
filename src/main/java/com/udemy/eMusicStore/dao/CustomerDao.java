package com.udemy.eMusicStore.dao;

import java.util.List;

import com.udemy.eMusicStore.model.Customer;

/**
 * @author sandeep.chauhan
 *
 */

public interface CustomerDao {
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	Customer getCustomerByUsername(String username);
	List<Customer> getAllCustomers();
}
