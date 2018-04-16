package com.udemy.eMusicStore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.udemy.eMusicStore.dao.CartDao;
import com.udemy.eMusicStore.dao.ProductDao;
import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;
import com.udemy.eMusicStore.model.Product;

/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable (value="cartId") String cartId){
		return cartDao.read(cartId);
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value="cartId") String cartId, @RequestBody Cart cart){
		cartDao.update(cartId, cart);
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable (value="cartId") String cartId){
		cartDao.delete(cartId);
	}
	
	//need to add , method=RequestMethod.PUT
	@RequestMapping(value="/add/{productId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable (value="productId") int productId, HttpServletRequest request){
		String sessionId = request.getSession().getId();
		System.out.println("the session id is "+ sessionId);
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null){
			cart = cartDao.create(new Cart(sessionId));
			System.out.println("new cart is created");
		}
		
		Product product = productDao.getProductById(productId);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}
		System.out.println("ready to insert into cart");
		cart.addCartItem(new CartItem(product));
		System.out.println("cart insertion complete");
		System.out.println("updating cart");
		cartDao.update(sessionId, cart);
		System.out.println("cart updated");
	}
	
	@RequestMapping(value="/remove/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable (value="productId") int productId, HttpServletRequest request){
		String sessionId = request.getSession().getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null){
			cart = cartDao.create(new Cart(sessionId));
		}
		
		Product product = productDao.getProductById(productId);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}
		cart.removeCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Illegal request. please verify your payload.")
	public void handleClientErrors(Exception e){
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="INTERNAL SERVER ERROR")
	public void handleServiceErrors(Exception e){
		
	}
	
}
