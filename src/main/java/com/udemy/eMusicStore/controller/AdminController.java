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
 * @author sandeep.chauhan
 *
 */
@Controller
public class AdminController {
	@Autowired
	private ProductDao productDao;
	Path path;
	@Autowired
	private ServletContext context;

	@RequestMapping("/admin*")
	public String adminPage(){
		System.out.println("atleast call reached the admin controller");
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getAllProducts();
		System.out.println(products);
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
	
	
	@RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
		System.out.println("the product received by the homecontroller is \n" + product);
		if(result.hasErrors()){
			return "addProduct";
		}
		
		System.out.println("going to add the product");
		productDao.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		/* 
		 * We can also get root directory by autowiring context and using following method
		 * String rootDirectory = context.getRealPath("/");
		 * 
		 */
		
		//Commenting this part as it is not working...hence hardcoding path. Will uncomment after changing to war exploaded.
//		System.out.println("the root directory is "+ rootDirectory);
//		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		
		path = Paths.get("C:\\Users\\sandeep.chauhan\\workspace3\\eCommerce\\src\\main\\webapp\\resources\\images\\"+product.getProductId()+".png");
		
		if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }	
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("C:\\Users\\sandeep.chauhan\\workspace3\\eCommerce\\src\\main\\webapp\\resources\\images\\"+id+".png");
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				System.out.println("error occured while deleting file.");
				e.printStackTrace();
			}
		}
		
		productDao.deleteProduct(id);
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable int id, Model model){
		Product product = productDao.getProductById(id);
		model.addAttribute(product);
		return "editProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/editProduct", method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request){
		if(result.hasErrors()){
			return "editProduct";
		}
		MultipartFile productImage = product.getProductImage();
		path = Paths.get("C:\\Users\\sandeep.chauhan\\workspace3\\eCommerce\\src\\main\\webapp\\resources\\images\\"+product.getProductId()+".png");
		if(productImage != null & !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e){
				throw new RuntimeException("product image saving failed", e);
			}
		}
		productDao.editProduct(product);
		return "redirect:/admin/productInventory";
	}
	
}