package com.udemy.eMusicStore.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author sandeep.chauhan
 *
 */
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -8831355268754774330L;
	
	@Id
	@GeneratedValue
	private int customerId;
	
	@NotEmpty(message="customer name must not be null")
	private String customerName;
	
	@NotEmpty(message="customerEmail must not be null")
	private String customerEmail;
	private String customerPhone;
	
	@NotEmpty(message="customer username shoud not be null")
	private String username;
	
	@NotEmpty(message="customer name cannot be empty")
	private String password;
	
	private boolean enanbled;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	
	@OneToOne
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnanbled() {
		return enanbled;
	}

	public void setEnanbled(boolean enanbled) {
		this.enanbled = enanbled;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
