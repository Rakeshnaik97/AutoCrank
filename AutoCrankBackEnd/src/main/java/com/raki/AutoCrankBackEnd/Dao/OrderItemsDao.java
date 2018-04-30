package com.raki.AutoCrankBackEnd.Dao;

import java.util.List;

import com.raki.AutoCrankBackEnd.Model.OrderItems;

public interface OrderItemsDao {

	public boolean saveorupdateOrderItems(OrderItems orderItems);

	public boolean deleteOrderItems(OrderItems orderItems);

	public OrderItems getOrderItems(String orderItemsId);

	public List<OrderItems> list();
}
