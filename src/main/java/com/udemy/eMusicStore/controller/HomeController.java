package com.udemy.eMusicStore.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
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
	
}
