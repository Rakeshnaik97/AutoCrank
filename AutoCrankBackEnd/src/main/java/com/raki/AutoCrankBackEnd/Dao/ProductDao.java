package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Product;

public interface ProductDao {
	public boolean saveorupdateProduct(Product product);

	public boolean deleteProduct(Product product);

	public Product getProduct(String productId);

	public List<Product> list();
}
