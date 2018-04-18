package com.udemy.eMusicStore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.eMusicStore.model.Product;
import com.udemy.eMusicStore.service.ProductService;

/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}
	
	@RequestMapping("/customer")
	public String customerManagement(Model model){
		//to add some customer services later
		return "customer";
	}
	

}
