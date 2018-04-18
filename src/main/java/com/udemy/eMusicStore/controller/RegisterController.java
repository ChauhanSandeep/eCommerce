package com.udemy.eMusicStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.udemy.eMusicStore.model.BillingAddress;
import com.udemy.eMusicStore.model.Customer;
import com.udemy.eMusicStore.model.ShippingAddress;
import com.udemy.eMusicStore.service.CustomerService;

/**
 * @author sandeep.chauhan
 *
 */

@Controller
public class RegisterController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		return "registerCustomer";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model){
		customer.setEnanbled(true);
		customerService.addCustomer(customer);
		return "registerCustomerSuccess";
	}

}
