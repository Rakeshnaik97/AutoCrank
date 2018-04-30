package com.raki.AutoCrankBackEnd.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
	private String cartId;
	private double cartGrandTotal = 0.0;
	private int cartTotalItems = 0;

	public Cart() {

		this.cartId = "CART" + UUID.randomUUID().toString().substring(30).toUpperCase();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "cart")
	private List<CartItems> cartItems;

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public double getCartGrandTotal() {
		return cartGrandTotal;
	}

	public void setCartGrandTotal(double cartGrandTotal) {
		this.cartGrandTotal = cartGrandTotal;
	}

	public int getCartTotalItems() {
		return cartTotalItems;
	}

	public void setCartTotalItems(int cartTotalItems) {
		this.cartTotalItems = cartTotalItems;
	}

}
