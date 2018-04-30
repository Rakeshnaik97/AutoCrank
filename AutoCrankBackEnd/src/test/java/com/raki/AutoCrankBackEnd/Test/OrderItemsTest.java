package com.raki.AutoCrankBackEnd.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raki.AutoCrankBackEnd.Dao.OrderDao;
import com.raki.AutoCrankBackEnd.Dao.OrderItemsDao;
import com.raki.AutoCrankBackEnd.Model.Order;
import com.raki.AutoCrankBackEnd.Model.OrderItems;

public class OrderItemsTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.raki.*");
		context.refresh();

		OrderItems orderItems = (OrderItems) context.getBean("orderItems");
		OrderItemsDao orderItemsDao = (OrderItemsDao) context.getBean("orderItemsDao");
		Order order = (Order) context.getBean("order");
		OrderDao orderDao = (OrderDao) context.getBean("orderDao");

		orderItems.setOrderItemsId("OI101");
		orderItems.setOrderProductId("productId");
		order = orderDao.getOrder("O101");
		orderItems.setOrder(order);

		if (orderItemsDao.saveorupdateOrderItems(orderItems) == true) {
			System.out.println("OrderItems Added successfully");
		} else {
			System.out.println("OrderItems Not Added ");
		}

		orderItems.setOrderItemsId("OI102");
		orderItems.setOrderProductId("productId");
		order = orderDao.getOrder("O102");
		orderItems.setOrder(order);
		if (orderItemsDao.saveorupdateOrderItems(orderItems) == true) {
			System.out.println("OrderItems Added successfully");
		} else {
			System.out.println("OrderItems Not Added ");
		}

		orderItems = orderItemsDao.getOrderItems("OI102");
		if (orderItemsDao.deleteOrderItems(orderItems) == true) {
			System.out.println("orderItem Deleted Successfully");
		} else {
			System.out.println("Orderitems not Deleted");
		}

		orderItems = orderItemsDao.getOrderItems("OI101");
		if (orderItems == null) {
			System.out.println("OrderItems Is Empty");
		} else {
			System.out.println("OrderItems List is:");
			System.out.println(orderItems.getOrder());
			System.out.println(orderItems.getOrderProductId());
		}

		List<OrderItems> list = orderItemsDao.list();
		for (OrderItems items : list) {
			System.out.println(items.getOrder());
			System.out.println(items.getOrderProductId());
		}
	}
}
