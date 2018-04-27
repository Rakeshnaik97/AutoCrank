package com.raki.AutoCrankBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Model.Category;

public class CategoryDaoImpl implements CategoryDao {

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getCategory(String catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
