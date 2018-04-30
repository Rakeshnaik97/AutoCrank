package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Model.Category;

public class CategoryTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.raki.*");
		context.refresh();
		Category cat = (Category) context.getBean("category");
		CategoryDao catDao = (CategoryDao) context.getBean("categoryDao");

		cat.setCatId("C101");
		cat.setCatName("Category1");
		if (catDao.saveorupdateCategory(cat) == true) {
			System.out.println("Category Added Successfully!");
		} else {
			System.out.println("Category Not  added! UnSuccessful!");
		}

		cat.setCatId("C102");
		cat.setCatName("Category2");
		if (catDao.saveorupdateCategory(cat) == true) {
			System.out.println("Category Added Successfully!");
		} else {
			System.out.println("Category Notadded!UnSuccessful!");
		}

		cat = catDao.getCategory("C102");
		if (catDao.deleteCategory(cat) == true) {
			System.out.println("Category Deleted Successfully");
		} else {
			System.out.println("Category not Deleted");
		}

		cat = catDao.getCategory("C101");
		if (cat == null) {
			System.out.println("Category is Empty");

		} else {
			System.out.println("Category Info:");
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}

		List<Category> clist = catDao.list();
		for (Category c : clist) {
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());
		}

	}
}
