package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Cart;

public interface CartDao {
	public boolean saveorupdateCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public Cart getCart(String cart);

	public List<Cart> list();
}
