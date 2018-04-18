package com.udemy.eMusicStore.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.udemy.eMusicStore.model.Product;
import com.udemy.eMusicStore.service.ProductService;

/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminProduct {
	
	private Path path;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	
	@RequestMapping(value="/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "addProduct";
		}
		productService.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root directory is "+ rootDirectory);
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if(productImage!=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("image saving failed");
			}
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="product/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id , Model model){
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@RequestMapping(value="/product/editProduct", method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "addProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root directory is "+ rootDirectory);
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if(productImage!=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("image saving failed");
			}
		}
		
		productService.editProduct(product);
		
		return "redirect:/admin/productInventory";
	}
	
	
	@RequestMapping(value="/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id, HttpServletRequest request){
		Product product = productService.getProductById(id);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root directory is "+ rootDirectory);
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		productService.deleteProduct(product);
		
		return "redirect:/admin/productInventory";
	}
	
}
