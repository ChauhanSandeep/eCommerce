package com.udemy.eMusicStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.udemy.eMusicStore.model.Cart;
import com.udemy.eMusicStore.model.CartItem;
import com.udemy.eMusicStore.model.Customer;
import com.udemy.eMusicStore.model.Product;
import com.udemy.eMusicStore.service.CartItemService;
import com.udemy.eMusicStore.service.CartService;
import com.udemy.eMusicStore.service.CustomerService;
import com.udemy.eMusicStore.service.ProductService;

/**
 * @author sandeep.chauhan
 *
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	@Autowired
	CartService cartService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable("cartId") int cartId, Model model){
		Cart cart = cartService.getCartById(cartId);
		return cart;
	}
	
	@RequestMapping(value="/add/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT) 
	public void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser){
		System.out.println("call reached to cart");
		String customerName = activeUser.getUsername();
		Customer customer = customerService.getCustomerByUsername(customerName);
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		
		Product product = productService.getProductById(productId);
		
		for(int i=0; i<cartItems.size(); i++){
			int cartProductId = cartItems.get(i).getProduct().getProductId();
			if(cartProductId == productId){
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		
		CartItem cartItem = new CartItem(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}
	
	@RequestMapping(value="/remove/{productId}", method= RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value="productId") int productId){
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable("cartId") int cartId){
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST , reason="Illegal request. Please verify your payload")
	public void handleClientErrors(Exception e){
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal server error")
	public void handleServerError(){
		
	}
	
	
}
