package com.udemy.eMusicStore.service;

import java.util.List;

import javax.persistence.Entity;

import com.udemy.eMusicStore.model.Product;

/**
 * @author sandeep.chauhan
 *
 */
public interface ProductService {
	
	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);

}
