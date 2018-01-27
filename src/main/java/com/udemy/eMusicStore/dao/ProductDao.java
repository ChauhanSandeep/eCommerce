package com.udemy.eMusicStore.dao;

import java.util.List;

import com.udemy.eMusicStore.model.Product;

/**
 * @author sandeep.chauhan
 *
 */
public interface ProductDao {
	
	void addProduct(Product product);
	Product getProductById(int id);
	List<Product> getAllProducts();
	void deleteProduct(int id);
	void editProduct(Product product);
}
