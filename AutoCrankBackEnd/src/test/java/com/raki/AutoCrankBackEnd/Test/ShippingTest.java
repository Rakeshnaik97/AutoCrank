package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.OrderDao;
import com.raki.AutoCrankBackEnd.Dao.ShippingDao;
import com.raki.AutoCrankBackEnd.Dao.UserDao;
import com.raki.AutoCrankBackEnd.Model.Order;
import com.raki.AutoCrankBackEnd.Model.Shipping;
import com.raki.AutoCrankBackEnd.Model.User;

public class ShippingTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.raki.*");
		context.refresh();

		Shipping shipping = ((Shipping) context.getBean("shipping"));
		ShippingDao shippingDao = ((ShippingDao) context.getBean("shippingDao"));
		User user = ((User) context.getBean("user"));
		UserDao userDao = ((UserDao) context.getBean("userDao"));
		Order order = (Order) context.getBean("order");
		OrderDao orderDao = (OrderDao) context.getBean("orderDao");

		shipping.setShippingId("SHIP101");
		shipping.setShippingName("Rakesh");
		shipping.setShippingPh_no("9738620777");
		shipping.setShippingAddress("Banglore");
		shipping.setShippingCountry("India");
		user = userDao.getUser("U101");
		shipping.setUser(user);
		order = orderDao.getOrder("O101");
		shipping.setOrder(order);
		if (shippingDao.saveorupdateShipping(shipping) == true) {
			System.out.println("Shipping Added Successful");
		} else {
			System.out.println("Shipping Not Added ");
		}

		shipping.setShippingId("SHIP102");
		shipping.setShippingName("Rakesh");
		shipping.setShippingPh_no("9738620777");
		shipping.setShippingAddress("Banglore");
		shipping.setShippingCountry("India");
		user = userDao.getUser("U102");
		shipping.setUser(user);
		order = orderDao.getOrder("O102");
		shipping.setOrder(order);
		if (shippingDao.saveorupdateShipping(shipping) == true) {
			System.out.println("Shipping Added Successful");
		} else {
			System.out.println("Shipping Not Added ");
		}

		shipping = shippingDao.getShipping("SHIP102");
		if (shippingDao.deleteShipping(shipping) == true) {
			System.out.println("Shipping Deleted ");
		} else {
			System.out.println("Shipping Not Deleted");
		}

		shipping = shippingDao.getShipping("SHIP101");
		if (shipping == null) {
			System.out.println("Shipping is Empty");
		} else {
			System.out.println("Shipping info:");
			System.out.println(shipping.getShippingId());
			System.out.println(shipping.getShippingName());
			System.out.println(shipping.getShippingPh_no());
			System.out.println(shipping.getShippingAddress());
			System.out.println(shipping.getShippingCountry());
			System.out.println(shipping.getOrder().getOrderId());
			System.out.println(shipping.getUser().getUserId());
		}

		List<Shipping> list = shippingDao.list();
		for (Shipping s : list) {
			System.out.println(s.getShippingId());
			System.out.println(s.getShippingName());
			System.out.println(s.getShippingPh_no());
			System.out.println(s.getShippingAddress());
			System.out.println(s.getShippingCountry());
			System.out.println(s.getOrder().getOrderId());
			System.out.println(s.getUser().getUserId());
		}

	}
}
