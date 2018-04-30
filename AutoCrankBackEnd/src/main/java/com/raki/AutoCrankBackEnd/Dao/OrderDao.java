package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.Order;

public interface OrderDao {

	public boolean saveorupdateOrder(Order order);

	public boolean deleteOrder(Order order);

	public Order getOrder(String orderId);

	public List<Order> list();
}
