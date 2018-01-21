package com.udemy.eMusicStore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.udemy.eMusicStore.model.Product;

/**
 * @author sandeep.chauhan
 *
 */
public class ProductDao {
	private List<Product> productList;
	public List<Product> getProductList(){
		Product product1 = new Product();
		product1.setProductId("product1");
		product1.setProductName("guitar");
		product1.setProductDescription("this is a fender strap guitar");
		product1.setProductCategory("instrument");
		product1.setProductPrice(1000);
		product1.setProductCondition("New");
		product1.setProductStatus("active");
		product1.setUnitInStock(10);
		product1.setProductManufacturer("Fender");
		
		
		Product product2 = new Product();
		product2.setProductId("product2");
		product2.setProductName("string");
		product2.setProductDescription("this is a fender strap string");
		product2.setProductCategory("accessaries");
		product2.setProductPrice(50);
		product2.setProductCondition("New");
		product2.setProductStatus("active");
		product2.setUnitInStock(100);
		product2.setProductManufacturer("Fender");
		
		productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		return productList;
	}
	
	public Product getProductById(String productId) throws IOException {
		for(Product product : productList){
			if(product.getProductId().equals(productId)){
				return product;
			}
		}
		throw new IOException("No product found");
	}
	

}
