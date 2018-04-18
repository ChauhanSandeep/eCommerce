package com.udemy.eMusicStore.service;

import com.udemy.eMusicStore.model.Customer;
import java.util.*;

/**
 * @author sandeep.chauhan
 *
 */
public interface CustomerService {
	
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomers();

}
