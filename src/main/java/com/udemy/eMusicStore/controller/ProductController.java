package com.udemy.eMusicStore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.eMusicStore.model.Product;

import com.udemy.eMusicStore.service.ProductService;



/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String getProducts(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products" , products);
		return "productList";
	}
	
	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable("id") int id, Model model) throws IOException{
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "viewProduct";
	}

}
