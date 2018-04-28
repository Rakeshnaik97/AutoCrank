package com.raki.AutoCrankBackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class OrderItems {
	@Id
	private String orderItemsId;
	private String orderProductId;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	public String getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(String orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public String getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(String orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



}
