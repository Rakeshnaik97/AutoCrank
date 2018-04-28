package com.raki.AutoCrankBackEnd.Model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Order {

	@Id
	private String orderId;
	private String orderDate;
	private String orderTime;
	private double orderGrandTotal;

	@OneToOne
	@JoinColumn(name = "billingId")
	private Billing billing;

	@OneToOne
	@JoinColumn(name = "shippingId")
	private Shipping shipping;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "order")
	private List<OrderItems> orderItems;

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public double getOrderGrandTotal() {
		return orderGrandTotal;
	}

	public void setOrderGrandTotal(double orderGrandTotal) {
		this.orderGrandTotal = orderGrandTotal;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

}
