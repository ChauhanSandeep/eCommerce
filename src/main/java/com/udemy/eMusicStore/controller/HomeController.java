package com.udemy.eMusicStore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.udemy.eMusicStore.dao.ProductDao;
import com.udemy.eMusicStore.model.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private ProductDao productDao;
	Path path;
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProduct(Model model){
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException{
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	
}
