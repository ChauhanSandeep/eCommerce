package com.udemy.eMusicStore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author sandeep.chauhan
 *
 */

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = 3940548625296145582L;

    @Id
//  @GeneratedValue
    private String cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

//    @OneToOne
//    @JoinColumn(name = "customerId")
//    @JsonIgnore
//    private Customer customer;

    private double grandTotal;

    /**
	 * @param sessionId
	 */
	public Cart(String sessionId) {
		this.cartId = sessionId;
	}

	public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    
    public void addCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		System.out.println("found product id "+ productId);
		boolean doesProductExists;
		try {
			doesProductExists = cartItems.contains(productId);
		} catch (Exception e) {
			// TODO: handle exception
			doesProductExists = false;
		}
		if (doesProductExists) {
			System.out.println("cart already contains item");
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.add(existingCartItem);
		} else {
			System.out.println("adding item to cart");
			cartItems.add(item);
		}
		System.out.println("udapted grand total");
		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}

	private void updateGrandTotal() {
		grandTotal = 0;
		Iterator<CartItem> iterator = cartItems.iterator();
		while(iterator.hasNext()){
			grandTotal += iterator.next().getTotalPrice();
		}
//		for(CartItem item: cartItems.values()){
//			grandTotal += item.getTotalPrice();
//		}
	}
}
