package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.CartItemsDao;
import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Dao.ProductDao;
import com.raki.AutoCrankBackEnd.Dao.SupplierDao;
import com.raki.AutoCrankBackEnd.Model.CartItems;
import com.raki.AutoCrankBackEnd.Model.Category;
import com.raki.AutoCrankBackEnd.Model.Product;
import com.raki.AutoCrankBackEnd.Model.Supplier;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.raki.*");
		ctx.refresh();
		Product pro = ((Product) ctx.getBean("product"));
		ProductDao proDao = ((ProductDao) ctx.getBean("productDao")); // Repositary Created In ProductDaoImpl Class
		Category cat = (Category) ctx.getBean("category");
		CategoryDao catDao = (CategoryDao) ctx.getBean("categoryDao");
		Supplier sup = (Supplier) ctx.getBean("supplier");
		SupplierDao supDao = (SupplierDao) ctx.getBean("supplierDao");
		CartItems cartItems = (CartItems) ctx.getBean("cartItems");
		CartItemsDao cartItemsDao = (CartItemsDao) ctx.getBean("cartItemsDao");

		pro.setProductId("P101");
		pro.setProductName("Product1");
		pro.setProductDescription("productDescription");
		pro.setProductPrice("999");
		pro.setProductQuantity("99");
		pro.setProductQuantity("99");
		cat = catDao.getCategory("C101"); // to fetch from categoryDao
		pro.setCategory(cat); // setCategory is passing category object

		sup = supDao.getSupplier("S101");
		pro.setSupplier(sup);

		cartItems = cartItemsDao.getCartItems("CTI101");
		pro.setCartItems(cartItems);

		proDao.saveorupdateProduct(pro); // to save the values in the product Table

		if (proDao.saveorupdateProduct(pro) == true) {
			System.out.println("Product is Added Succesfully");
		} else {
			System.out.println("Product Not added");
		}

		pro.setProductId("P102");
		pro.setProductName("Product2");
		pro.setProductDescription("productDescription");
		pro.setProductPrice("999");
		pro.setProductQuantity("99");

		cat = catDao.getCategory("C102"); // to fetch from categoryDao
		pro.setCategory(cat); // setCategory is passing category object

		sup = supDao.getSupplier("S102");
		pro.setSupplier(sup);

		cartItems = cartItemsDao.getCartItems("CTI102");
		pro.setCartItems(cartItems);

		proDao.saveorupdateProduct(pro); // to save the values in the product Table

		if (proDao.saveorupdateProduct(pro) == true) {
			System.out.println("Product is Added Succesfully");
		} else {
			System.out.println("Product Not added");
		}

		pro = proDao.getProduct("P102");
		if (proDao.deleteProduct(pro) == true) {
			System.out.println("Product Deleted");
		} else {
			System.out.println("Product Not Deleted");
		}

		pro = proDao.getProduct("P101");
		if (pro == null) {
			System.out.println("Product Is Empty");
		} else {
			System.out.println("Product Info:");
			System.out.println(pro.getProductId());
			System.out.println(pro.getProductName());
			System.out.println(pro.getProductDescription());
			System.out.println(pro.getProductPrice());
			System.out.println(pro.getProductQuantity());
			System.out.println(pro.getCategory().getCatId());
			System.out.println(pro.getSupplier().getSupplierId());
			System.out.println(pro.getCartItems().getCartItemsId());
		}

		List<Product> plist = proDao.list();
		for (Product p : plist) {
			System.out.println(p.getProductId());
			System.out.println(p.getProductName());
			System.out.println(p.getProductDescription());
			System.out.println(p.getProductPrice());
			System.out.println(p.getProductQuantity());
			System.out.println(p.getCategory().getCatId());
			System.out.println(p.getSupplier().getSupplierId());
			System.out.println(p.getCartItems().getCartItemsId());
		}
	}
}
