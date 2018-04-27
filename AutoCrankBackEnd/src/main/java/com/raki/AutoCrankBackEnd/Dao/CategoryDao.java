package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Category;

public interface CategoryDao {
	public boolean saveorupdateCategory(Category category);

	public boolean deleteCategory(Category category);

	public Category getCategory(String catId);

	public List<Category> list();
}
