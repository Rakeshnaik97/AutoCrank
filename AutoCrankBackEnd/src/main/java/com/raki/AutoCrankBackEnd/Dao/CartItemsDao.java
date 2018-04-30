package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.CartItems;

public interface CartItemsDao {
	public boolean saveorupdateCartItems(CartItems cartItems);

	public boolean deleteCartItems(CartItems cartItems);

	public CartItems getCartItems(String cartItemsId);

	public List<CartItems> list();
}
