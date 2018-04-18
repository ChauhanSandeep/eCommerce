package com.udemy.eMusicStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.eMusicStore.dao.ProductDao;
import com.udemy.eMusicStore.model.Product;
import com.udemy.eMusicStore.service.ProductService;

/**
 * @author sandeep.chauhan
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductList() {
		return productDao.getAllProducts();
	}


	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}


	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}


	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);
	}


	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
		
	}

}
