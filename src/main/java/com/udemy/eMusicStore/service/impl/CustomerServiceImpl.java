package com.udemy.eMusicStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.eMusicStore.dao.CustomerDao;
import com.udemy.eMusicStore.model.Customer;
import com.udemy.eMusicStore.service.CustomerService;

/**
 * @author sandeep.chauhan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	@Override
	public Customer getCustomerById(int id){
		return customerDao.getCustomerById(id);
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}

}
