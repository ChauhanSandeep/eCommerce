package com.udemy.eMusicStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.eMusicStore.model.Customer;
import com.udemy.eMusicStore.service.CustomerService;

/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	CustomerService customerService;
	/*
	 * AuthenticationPrincipal is used to get the data about the logged in user.
	 * We need to use spring security version 3.2.5 in pom.xml and give proper argument resolver in dispatcher servlet
	 * under mvc:annotation driven.
	 * I also needed to change the spring version from 3 to 4.1.4 release.
	 */
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeUser){
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		int cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/"+cartId;
		
	}
	
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable("cartid") int cartId, Model model){
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}

}
