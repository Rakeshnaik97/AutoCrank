package com.raki.AutoCrankBackEnd.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	@Id
	private String cartItemsId;
	private double CartItemsPrice;

	public CartItems() {
		// TODO Auto-generated constructor stub
		this.cartItemsId = "CARTITEM" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	@ManyToOne
	@JoinColumn(name = "cartId")

	private Cart cart;

	@OneToOne
	@JoinColumn(name = "productId")

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(String cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public double getCartItemsPrice() {
		return CartItemsPrice;
	}

	public void setCartItemsPrice(double cartItemsPrice) {
		CartItemsPrice = cartItemsPrice;
	}

}
