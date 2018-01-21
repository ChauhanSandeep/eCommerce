package com.udemy.eMusicStore.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.eMusicStore.dao.ProductDao;
import com.udemy.eMusicStore.model.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private ProductDao productDao = new ProductDao();
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProduct(Model model){
		List<Product> products = productDao.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model) throws IOException{
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	
	@RequestMapping("/admin*")
	public String adminPage(){
		System.out.println("atleast call reached the admin controller");
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getProductList();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
}
